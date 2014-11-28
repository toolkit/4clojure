(ns puzzle-solutions.sequences-map
  (:require [clojure.test :refer [is]]))

;; Problem 17 - Sequences: Map
;; http://www.4clojure.com/problem/17

(def __ '(6 7 8))

(is (= __ (map #(+ % 5) '(1 2 3))))
