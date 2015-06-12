(ns sequences-map.core
  (:require [clojure.test :refer :all]))

;; Problem 17 - Sequences: Map
;; http://www.4clojure.com/problem/17

(def __ '(6 7 8))

(deftest tests
  (is (= __ (map #(+ % 5) '(1 2 3)))))
