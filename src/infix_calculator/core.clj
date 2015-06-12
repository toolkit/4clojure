(ns infix-calculator.core
  (:require [clojure.test :refer :all]))

;; Problem 135 - Infix Calculator
;; http://www.4clojure.com/problem/135

(def __ (fn [x & xs]
          (reduce #((first %2) % (second %2)) x (partition 2 xs))))

(deftest tests
  (is (= 7  (__ 2 + 5)))
  (is (= 42 (__ 38 + 48 - 2 / 2)))
  (is (= 8  (__ 10 / 2 - 1 * 2)))
  (is (= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))))
