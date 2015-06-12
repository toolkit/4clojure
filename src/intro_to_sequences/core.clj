(ns intro-to-sequences.core
  (:require [clojure.test :refer :all]))

;; Problem 12 - Intro to Sequences
;; http://www.4clojure.com/problem/12

(def __ 3)

(deftest tests
  (is (= __ (first '(3 2 1))))
  (is (= __ (second [2 3 4])))
  (is (= __ (last (list 1 2 3)))))
