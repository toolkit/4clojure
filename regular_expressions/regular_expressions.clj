(ns regular-expressions
  (:require [clojure.test :refer :all]))

;; Problem 37 - Regular Expressions
;; http://www.4clojure.com/problem/37

(def __ "ABC")

(is (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce"))))
