(ns intro-to-strings
  (:require [clojure.test :refer :all]))

;; Problem 3 - Intro to Strings
;; http://www.4clojure.com/problem/3

(def __ "HELLO WORLD")

(deftest tests
  (is (= __ (.toUpperCase "hello world"))))
