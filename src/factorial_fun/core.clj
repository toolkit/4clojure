(ns factorial-fun.core
  (:require [clojure.test :refer :all]))

;; Problem 42 - Factorial Fun
;; http://www.4clojure.com/problem/42

(def __ #(apply * (range 1 (inc %))))

(deftest tests
  (is (= (__ 1) 1))
  (is (= (__ 3) 6))
  (is (= (__ 5) 120))
  (is (= (__ 8) 40320)))
