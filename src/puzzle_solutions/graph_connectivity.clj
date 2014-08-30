(ns puzzle-solutions.graph-connectivity
  (:require [clojure.test :refer [is]]))

;; Problem 91 - Graph Connectivity
;; http://www.4clojure.com/problem/91

(def __ (fn connected? [edges]
          (let [sets (set (map set edges))
                total (count (set (mapcat identity sets)))
                grow (fn [nodes]
                       (set (mapcat identity (for [n nodes s sets :when (contains? s n)] s))))
                connected (loop [nodes #{(ffirst sets)}]
                            (let [new-nodes (grow nodes)]
                              (if (= new-nodes nodes)
                                nodes
                                (recur new-nodes))))]
            (= total (count connected)))))

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