(ns puzzle-solutions.comparisons
  (:require [clojure.test :refer [is]]))

;; Problem 166 - Comparisons
;; http://www.4clojure.com/problem/166

(def __ (fn [f x y]
  (cond
   (f x y) :lt
   (f y x) :gt
   :else :eq)))

(is (= :gt (__ < 5 1)))
(is (= :eq (__ (fn [x y] (< (count x) (count y))) "pear" "plum")))
(is (= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3)))
(is (= :gt (__ > 0 2)))
