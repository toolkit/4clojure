(ns puzzle-solutions.recurring-theme
  (:require [clojure.test :refer [is]]))

;; Problem 68 - Recurring Theme
;; http://www.4clojure.com/problem/68

(def __ [7 6 5 4 3])

(is (= __
       (loop [x 5
              result []]
         (if (> x 0)
           (recur (dec x) (conj result (+ 2 x)))
           result))))
