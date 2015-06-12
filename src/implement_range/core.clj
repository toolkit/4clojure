(ns implement-range.core
  (:require [clojure.test :refer :all]))

;; Problem 34 - Implement Range
;; http://www.4clojure.com/problem/34

(def __ #(take-while (fn [x] (< x %2))
                     (iterate inc %1)))

(deftest tests
  (is (= (__ 1 4) '(1 2 3)))
  (is (= (__ -2 2) '(-2 -1 0 1)))
  (is (= (__ 5 8) '(5 6 7))))
