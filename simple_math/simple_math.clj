(ns simple-math
  (:require [clojure.test :refer :all]))

;; Problem 2 - Simple Math
;; http://www.4clojure.com/problem/2

(def __ 4)

(deftest tests
  (is (= (- 10 (* 2 3)) __)))
