(ns puzzle-solutions.vectors-conj
  (:require [clojure.test :refer [is]]))

;; Problem 7 - Vectors: Conj
;; http://www.4clojure.com/problem/7

(def __ [1 2 3 4])

(is (= __ (conj [1 2 3] 4)))
(is (= __ (conj [1 2] 3 4)))
