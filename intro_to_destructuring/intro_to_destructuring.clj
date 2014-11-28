(ns puzzle-solutions.intro-to-destructuring
  (:require [clojure.test :refer [is]]))

;; Problem 53 - Intro to Destructuring
;; http://www.4clojure.com/problem/53

(is (= [2 4] (let [[a b c d e f g] (range)] [c e])))
