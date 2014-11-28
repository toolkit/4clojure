(ns puzzle-solutions.find-distinct-items
  (:require [clojure.test :refer [is]]))

;; Problem 56 - Find Distinct Items
;; http://www.4clojure.com/problem/56

(def __ #(seq (java.util.LinkedHashSet. %)))

(is (= (__ [1 2 1 3 1 2 4]) [1 2 3 4]))
(is (= (__ [:a :a :b :b :c :c]) [:a :b :c]))
(is (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
(is (= (__ (range 50)) (range 50)))
