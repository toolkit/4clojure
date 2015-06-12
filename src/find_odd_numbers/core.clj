(ns find-odd-numbers.core
  (:require [clojure.test :refer :all]))

;; Problem 25 - Find the odd numbers
;; http://www.4clojure.com/problem/25

(def __ #(filter odd? %))

(deftest tests
  (is (= (__ #{1 2 3 4 5}) '(1 3 5)))
  (is (= (__ [4 2 1 6]) '(1)))
  (is (= (__ [2 2 4 6]) '()))
  (is (= (__ [1 1 1 3]) '(1 1 1 3))))
