(ns intro-to-strings
  (:require [clojure.test :refer [is]]))

;; Problem 3 - Intro to Strings
;; http://www.4clojure.com/problem/3

(def __ "HELLO WORLD")

(is (= __ (.toUpperCase "hello world")))
