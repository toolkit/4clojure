(ns intro-to-reduce
  (:require [clojure.test :refer :all]))

;; Problem 64 - Intro to Reduce
;; http://www.4clojure.com/problem/64

(def __ +)

(deftest tests
  (is (= 15 (reduce __ [1 2 3 4 5])))
  (is (=  0 (reduce __ [])))
  (is (=  6 (reduce __ 1 [2 3]))))
