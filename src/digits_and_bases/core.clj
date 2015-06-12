(ns digits-and-bases.core
  (:require [clojure.test :refer :all]))

;; Problem 137 - Digits and Bases
;; http://www.4clojure.com/problem/137

(def __ (fn [n rdx]
          (loop [q (quot n rdx)
                 r (rem n rdx)
                 a []]
            (if (zero? q)
              (cons r a)
              (recur (quot q rdx)
                     (rem q rdx)
                     (cons r a))))))

(deftest tests
  (is (= [1 2 3 4 5 0 1] (__ 1234501 10)))
  (is (= [0] (__ 0 11)))
  (is (= [1 0 0 1] (__ 9 2)))
  (is (= [1 0] (let [n (rand-int 100000)](__ n n))))
  (is (= [16 18 5 24 15 1] (__ Integer/MAX_VALUE 42))))
