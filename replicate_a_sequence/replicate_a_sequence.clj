(ns replicate-a-sequence
  (:require [clojure.test :refer :all]))

;; Problem 33 - Replicate a Sequence
;; http://www.4clojure.com/problem/33

(def __ #(mapcat (partial repeat %2) %1))

(is (= (__ [1 2 3] 2) '(1 1 2 2 3 3)))
(is (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
(is (= (__ [4 5 6] 1) '(4 5 6)))
(is (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
(is (= (__ [44 33] 2) [44 44 33 33]))
