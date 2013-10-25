(ns puzzle-solutions.simple-closures
  (:require [clojure.test :refer [is]]))

;; Problem 107 - Simple Closures
;; http://www.4clojure.com/problem/107

(def __ (fn [n] (fn [x] (apply * (repeat n x)))))

(is (= 256
       ((__ 2) 16),
       ((__ 8) 2)))
(is (= [1 8 27 64] (map (__ 3) [1 2 3 4])))
(is (= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4])))
