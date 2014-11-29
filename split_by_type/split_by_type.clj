(ns split-by-type
  (:require [clojure.test :refer :all]))

;; Problem 50 - Split by Type
;; http://www.4clojure.com/problem/50

(def __ #(vals (group-by type %)))

(is (= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
(is (= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
(is (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))
