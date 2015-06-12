(ns eulers-totient.core
  (:require [clojure.test :refer :all]))

;; Problem 75 - Eulers Totient
;; http://www.4clojure.com/problem/75

(def __ (fn [x]
          (if (= 1 x) 1
              (letfn [(gcd [a b] (last (filter #(and (zero? (mod a %)) (zero? (mod b %))) (range 1 (max a b)))))
                      (coprime? [a b] (= 1 (gcd a b)))]
                (count (filter (partial coprime? x) (range 1 x)))))))

(deftest tests
  (is (= (__ 1) 1))
  (is (= (__ 10) (count '(1 3 7 9)) 4))
  (is (= (__ 40) 16))
  (is (= (__ 99) 60)))
