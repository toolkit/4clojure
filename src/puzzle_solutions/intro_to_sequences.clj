(ns puzzle-solutions.intro-to-sequences
  (:require [clojure.test :refer [is]]))

;; Problem 12 - Intro to Sequences
;; http://www.4clojure.com/problem/12

(def __ 3)

(is (= __ (first '(3 2 1))))
(is (= __ (second [2 3 4])))
(is (= __ (last (list 1 2 3))))
