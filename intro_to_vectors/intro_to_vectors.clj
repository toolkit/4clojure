(ns intro-to-vectors
  (:require [clojure.test :refer :all]))

;; Problem 6 - Intro to Vectors
;; http://www.4clojure.com/problem/6

(is (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))
