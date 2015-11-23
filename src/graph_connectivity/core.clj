(ns graph-connectivity.core
  (:use [midje.sweet]))

;; Problem 91 - Graph Connectivity
;; http://www.4clojure.com/problem/91

(def __ (fn connected? [edges]
          (let [sets (set (map set edges))
                nodes (set (mapcat identity sets))
                grow (fn [nodes]
                       (set (mapcat identity (for [n nodes s sets :when (contains? s n)] s))))
                connected (loop [prev #{(first nodes)} next (grow prev)]
                            (if (= prev next) prev (recur next (grow next))))]
            (= nodes connected))))

(facts "about graph connectivity"
       (__ #{[:a :a]})                                                 => true
       (__ #{[:a :b]})                                                 => true
       (__ #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]})                     => false
       (__ #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4] [3 4]})               => true
       (__ #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e]})         => false
       (__ #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e] [:x :a]}) => true)
