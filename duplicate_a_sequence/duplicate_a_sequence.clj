(ns duplicate-a-sequence
  (:require [clojure.test :refer [is]]))

;; Problem 32 - Duplicate a Sequence
;; http://www.4clojure.com/problem/32

(def __ #(mapcat (partial repeat 2) %))

(is (= (__ [1 2 3]) '(1 1 2 2 3 3)))
(is (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
(is (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
