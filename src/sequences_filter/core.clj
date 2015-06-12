(ns sequences-filter.core
  (:require [clojure.test :refer :all]))

;; Problem 18 - Sequences: Filter
;; http://www.4clojure.com/problem/18

(def __ [6 7])

(deftest tests
  (is (= __ (filter #(> % 5) '(3 4 5 6 7)))))
