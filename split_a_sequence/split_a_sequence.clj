(ns split-a-sequence
  (:require [clojure.test :refer :all]))

;; Problem 49 - Split a Sequence
;; http://www.4clojure.com/problem/49

(def __ (juxt take drop))

(deftest tests
  (is (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
  (is (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
  (is (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))
