(ns indexing-sequences.core
  (:require [clojure.test :refer :all]))

;; Problem 157 - Indexing Sequences
;; http://www.4clojure.com/problem/157

(def __ #(map list % (range)))

(deftest tests
  (is (= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]]))
  (is (= (__ [0 1 3]) '((0 0) (1 1) (3 2))))
  (is (= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])))
