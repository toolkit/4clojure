(ns intro-to-destructuring.core
  (:require [clojure.test :refer :all]))

;; Problem 52 - Intro to Destructuring
;; http://www.4clojure.com/problem/52

(deftest tests
  (is (= [2 4] (let [[a b c d e f g] (range)] [c e]))))
