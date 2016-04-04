(ns gus-quinundrum.core
  (:require [clojure.test :refer :all]))

;; Problem 125 - Gus' Quinundrum
;; http://www.4clojure.com/problem/125

(def __ (fn [] "__"))

(deftest tests
  (is (= (str '__) (__))))

(str '__)

(= (str '__) (__))

(def a [1 2 3 4])

