(ns graph-tour.core
  (:require [clojure.test :refer :all]))

;; Problem 89 - Graph Tour
;; https://www.4clojure.com/problem/89

;; See also http://www.graph-magics.com/articles/euler.php

(def __ (fn [edges]
          (let [edges (map set edges)
                vertices (fn [edges] (set (mapcat identity edges)))
                neighbour-edge (fn [vertex edge] (contains? edge vertex))
                neighbour-edges (fn [vertex edges] (filter (partial neighbour-edge vertex) edges))
                degree (fn [vertex] (count (neighbour-edges vertex edges)))
                odds (filter odd? (map degree (vertices edges)))
                visit-next (fn [visited-vertices]
                             (vertices (mapcat #(neighbour-edges % edges) visited-vertices)))
                visit-all (loop [previous #{(first (vertices edges))}
                                 next (visit-next previous)]
                            (if (= previous next) previous (recur next (visit-next next))))
                connected? (= (vertices edges) visit-all)
                path-or-circuit (cond
                                   (and connected? (= 0 (count odds))) :circuit
                                   (and connected? (= 2 (count odds))) :path)]
            (not (nil? path-or-circuit)))))

(deftest tests
  (is (= true (__ [[:a :b]])))
  (is (= false (__ [[:a :a] [:b :b]])))
  (is (= false (__ [[:a :b] [:a :b] [:a :c] [:c :a] [:a :d] [:b :d] [:c :d]])))
  (is (= true (__ [[1 2] [2 3] [3 4] [4 1]])))
  (is (= true (__ [[:a :b] [:a :c] [:c :b] [:a :e]
                   [:b :e] [:a :d] [:b :d] [:c :e]
                   [:d :e] [:c :f] [:d :f]])))
  (is (= false (__ [[1 2] [2 3] [2 4] [2 5]]))))
