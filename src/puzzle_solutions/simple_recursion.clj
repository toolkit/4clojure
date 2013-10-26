(ns puzzle-solutions.simple-recursion
  (:require [clojure.test :refer [is]]))

;; Problem 57 - Simple Recursion
;; http://www.4clojure.com/problem/57

(def __ [5 4 3 2 1])

(is (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)))
