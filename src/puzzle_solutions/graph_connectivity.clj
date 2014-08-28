(ns puzzle-solutions.graph-connectivity
  (:require [clojure.test :refer [is]]))

;; Problem 66 - Graph Connectivity
;; http://www.4clojure.com/problem/91

(def __ (fn [edges]
          (let [both-directions (fn [edges]
                                  (into edges (map reverse edges)))
                complete (fn [node-neighbours visited]
                           (let [visit-next (set (mapcat second (select-keys node-neighbours visited)))]
                             (if (or (empty? node-neighbours) (empty? visit-next))
                               visited
                               (recur (apply dissoc node-neighbours visited)
                                      (into visited visit-next)))))
                node-neighbours (into {} (map (fn [[k v]] [k (map second v)]) (group-by first (both-directions edges))))]
            (let [[start-node _] (first node-neighbours)]
              (= (set (keys node-neighbours))
                 (complete node-neighbours #{start-node}))))))

(is (= true (__ #{[:a :a]})))
(is (= true (__ #{[:a :b]})))
(is (= false (__ #{[1 2] [2 3] [3 1]
                   [4 5] [5 6] [6 4]})))
(is (= true (__ #{[1 2] [2 3] [3 1]
                  [4 5] [5 6] [6 4] [3 4]})))
(is (= false (__ #{[:a :b] [:b :c] [:c :d]
                   [:x :y] [:d :a] [:b :e]})))
(is (= true (__ #{[:a :b] [:b :c] [:c :d]
                  [:x :y] [:d :a] [:b :e] [:x :a]})))