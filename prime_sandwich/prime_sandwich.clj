(ns prime-sandwich
  (:require [clojure.test :refer :all]))

;; Problem 116 - Prime Sandwich
;; http://www.4clojure.com/problem/116

(def __
  (fn [x]
    (let [p? (fn [n] (not-any? zero? (map #(mod n %) (range 2 n))))
          a (first (filter p? (iterate dec (dec x))))
          b (first (filter p? (iterate inc (inc x))))]
      (and
       (> x 3)
       (p? x)
       (= x (/ (+ a b) 2))))))

(deftest tests
  (is (= false (__ 4)))
  (is (= true (__ 563)))
  (is (= 1103 (nth (filter __ (range)) 15))))
