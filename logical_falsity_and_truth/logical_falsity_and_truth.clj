(ns logical-falsity-and-truth
  (:require [clojure.test :refer :all]))

;; Problem 162 - Logical Falsity and Truth
;; http://www.4clojure.com/problem/162

(def __ 1)

(deftest tests
  (is (= __ (if-not false 1 0)))
  (is (= __ (if-not nil 1 0)))
  (is (= __ (if true 1 0)))
  (is (= __ (if [] 1 0)))
  (is (= __ (if [0] 1 0)))
  (is (= __ (if 0 1 0)))
  (is (= __ (if 1 1 0))))
