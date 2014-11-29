(ns interleave-two-sequences
  (:require [clojure.test :refer :all]))

;; Problem 39 - Interleave two sequences
;; http://www.4clojure.com/problem/39

(def __ (fn [xs ys]
          (flatten
           (loop [a xs
                  b ys
                  r []]
             (if (or (nil? a) (nil? b))
               r
               (recur (next a) (next b) (conj r [(first a) (first b)])))))))

(deftest tests
  (is (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (__ [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (__ [1 2 3 4] [5]) [1 5]))
  (is (= (__ [30 20] [25 15]) [30 25 20 15])))
