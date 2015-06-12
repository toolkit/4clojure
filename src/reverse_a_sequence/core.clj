(ns reverse-a-sequence.core
  (:require [clojure.test :refer :all]))

;; Problem 23 - Reverse a Sequence
;; http://www.4clojure.com/problem/23

(def __ #(into () %))

(deftest tests
  (is (= (__ [1 2 3 4 5]) [5 4 3 2 1]))
  (is (= (__ (sorted-set 5 7 2 7)) '(7 5 2)))
  (is (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])))
