(ns fibonacci-sequence
  (:require [clojure.test :refer :all]))

;; Problem 26 - Fibonacci Sequence
;; http://www.4clojure.com/problem/26

(def __ (fn [x]
          (take x
                (map last
                     (iterate (fn [[a b]]  [b (+ a b)]) [0 1])))))

(deftest tests
  (is (= (__ 3) '(1 1 2)))
  (is (= (__ 6) '(1 1 2 3 5 8)))
  (is (= (__ 8) '(1 1 2 3 5 8 13 21))))
