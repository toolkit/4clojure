(ns puzzle-solutions.global-take-while
  (:require [clojure.test :refer [is]]))

;; Problem 114 - Global take while
;; http://www.4clojure.com/problem/114

(def __ (fn [n p s]
          (take
           (last
            (take n (keep-indexed #(if (p %2) %) s)))
           s)))

(is (= [2 3 5 7 11 13]
   (__ 4 #(= 2 (mod % 3))
       [2 3 5 7 11 13 17 19 23])))
(is (= ["this" "is" "a" "sentence"]
   (__ 3 #(some #{\i} %)
         ["this" "is" "a" "sentence" "i" "wrote"])))
(is (= ["this" "is"]
   (__ 1 #{"a"}
         ["this" "is" "a" "sentence" "i" "wrote"])))
