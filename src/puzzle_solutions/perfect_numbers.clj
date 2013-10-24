(ns puzzle-solutions.perfect-numbers
  (:require [clojure.test :refer [is]]))

;; Problem 80 - Perfect Numbers
;; http://www.4clojure.com/problem/80

(def __ (fn [x]
          (= x (reduce + (filter #(zero? (mod x %)) (range 1 x))))))

(is (= (__ 6) true))
(is (= (__ 7) false))
(is (= (__ 496) true))
(is (= (__ 500) false))
(is (= (__ 8128) true))
