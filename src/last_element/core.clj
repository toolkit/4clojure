(ns last-element.core
  (:require [clojure.test :refer :all]))

;; Problem 19 - Last Element
;; http://www.4clojure.com/problem/19

(def __ #(nth % (dec (count %))))

(deftest tests
  (is (= (__ [1 2 3 4 5]) 5))
  (is (= (__ '(5 4 3)) 3))
  (is (= (__ ["b" "c" "d"]) "d")))
