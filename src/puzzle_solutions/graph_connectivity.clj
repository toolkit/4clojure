(ns puzzle-solutions.graph-connectivity
  (:require [clojure.test :refer [is]]))

;; Problem 66 - Graph Connectivity
;; http://www.4clojure.com/problem/91

(def __ (fn [edges]
          (let [both-directions (fn [edges]
                                  (into edges (map reverse edges)))
                neighbours (fn [edges]
                             (into {} (map (fn [[k v]] [k (map second v)]) (group-by first (both-directions edges)))))

                complete-helper (fn [nedges visited]
                                  (let [neigbours-to-visited (set (mapcat second (select-keys nedges visited)))]
                                    (if (or (empty? nedges) (empty? neigbours-to-visited))
                                      visited
                                      (recur (apply dissoc nedges visited)
                                             (apply conj visited neigbours-to-visited)))))
                nedges (neighbours edges)]
            (let [[node _] (first nedges)]
              (= (set (keys nedges))
                 (complete-helper nedges #{node}))))))

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