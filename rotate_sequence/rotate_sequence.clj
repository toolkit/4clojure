(ns rotate-sequence
  (:require [clojure.test :refer [is]]))

;; Problem 44 - Rotate Sequence
;; http://www.4clojure.com/problem/44

(def __ #(take (count %2) (drop (mod %1 (count %2)) (cycle %2))))

(is (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2)))
(is (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3)))
(is (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1)))
(is (= (__ 1 '(:a :b :c)) '(:b :c :a)))
(is (= (__ -4 '(:a :b :c)) '(:c :a :b)))
