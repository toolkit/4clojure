(ns puzzle-solutions.penultimate-element
  (:require [clojure.test :refer [is]]))

;; Problem 20 - Penultimate Element
;; http://www.4clojure.com/problem/20

(def __ (comp second reverse))

(is (= (__ (list 1 2 3 4 5)) 4))
(is (= (__ ["a" "b" "c"]) "b"))
(is (= (__ [[1 2] [3 4]]) [1 2]))
