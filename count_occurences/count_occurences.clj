(ns count-occurences
  (:require [clojure.test :refer [is]]))

;; Problem 55 - Count Occurences
;; http://www.4clojure.com/problem/55

(def __ (fn [s] (reduce #(update-in % [%2] (fnil inc 0)) {} s)))

(is (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
(is (= (__ [:b :a :b :a :b]) {:a 2, :b 3}))
(is (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))
