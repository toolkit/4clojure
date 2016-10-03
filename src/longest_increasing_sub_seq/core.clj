(ns longest-increasing-sub-seq.core
  (:require [clojure.test :refer :all]))

;; Problem 53 - Longest Inscreasing Sub-seq
;; http://www.4clojure.com/problem/53

(def __ (fn [c]
          (->> c
               (map-indexed (fn [i v] [(- i v) v]))
               (partition-by first)
               (filter #(> (count %) 1))
               (reduce (fn [a s] (if (> (count a) (count s)) a s)) [])
               (map last))))

(deftest tests
  (is (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (is (= (__ [5 6 1 3 2 7]) [5 6]))
  (is (= (__ [2 3 3 4 5]) [3 4 5]))
  (is (= (__ [7 6 5 4]) [])))
