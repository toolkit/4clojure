(ns sequence-reductions
  (:require [clojure.test :refer :all]))

;; Problem 60 - Sequence Reductions
;; http://www.4clojure.com/problem/60

(def __ (fn red
          ([f a] (red f (first a) (rest a)))
          ([f i a]
             (cons i
                   (lazy-seq
                    (when (seq a)
                      (red f (f i (first a)) (rest a))))))))

(deftest tests
  (is (= (take 5 (__ + (range))) [0 1 3 6 10]))
  (is (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))
  (is (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)))
