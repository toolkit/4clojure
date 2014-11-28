(ns last-element
  (:require [clojure.test :refer [is]]))

;; Problem 19 - Last Element
;; http://www.4clojure.com/problem/19

(def __ #(nth % (dec (count %))))

(is (= (__ [1 2 3 4 5]) 5))
(is (= (__ '(5 4 3)) 3))
(is (= (__ ["b" "c" "d"]) "d"))
