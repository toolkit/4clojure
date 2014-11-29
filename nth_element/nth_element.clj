(ns nth-element
   (:require [clojure.test :refer :all]))

;; Problem 21 - Nth Element
;; http://www.4clojure.com/problem/21

(def __ #(last (take (inc %2) %1)))

(deftest tests
  (is (= (__ '(4 5 6 7) 2) 6))
  (is (= (__ [:a :b :c] 0) :a))
  (is (= (__ [1 2 3 4] 1) 2))
  (is (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])))
