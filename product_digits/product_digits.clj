(ns product-digits
  (:require [clojure.test :refer :all]))

;; Problem 99 - Product Digits
;; http://www.4clojure.com/problem/99

(def __
  (fn [a b]
    (let [x (* a b)]
      (loop [q (quot x 10)
             r (rem x 10)
             v '()]
        (if (= 0 q)
          (conj v r)
          (recur (quot q 10) (rem q 10) (conj v r)))))))

(deftest tests
  (is (= (__ 1 1) [1]))
  (is (= (__ 99 9) [8 9 1]))
  (is (= (__ 999 99) [9 8 9 0 1])))
