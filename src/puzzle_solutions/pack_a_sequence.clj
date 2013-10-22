(ns puzzle-solutions.pack-a-sequence
   (:require [clojure.test :refer [is]]))

;; Problem 31 - Pack a Sequence
;; http://www.4clojure.com/problem/31

(def __ #(partition-by identity %))

(is (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
(is (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
(is (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))
