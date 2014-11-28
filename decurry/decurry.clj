(ns decurry
  (:require [clojure.test :refer [is]]))

;; Problem 158 - Decurry
;; http://www.4clojure.com/problem/158

(def __(fn [f]
  (fn [& args]
    (reduce #(%1 %2) f args))))

(is (= 10 ((__ (fn [a]
                 (fn [b]
                   (fn [c]
                     (fn [d]
                       (+ a b c d))))))
           1 2 3 4)))

(is (= 24 ((__ (fn [a]
                 (fn [b]
                   (fn [c]
                     (fn [d]
                       (* a b c d))))))
           1 2 3 4)))

(is (= 25 ((__ (fn [a]
                 (fn [b]
                   (* a b))))
           5 5)))
