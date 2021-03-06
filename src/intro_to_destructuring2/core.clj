(ns intro-to-destructuring2.core
  (:require [clojure.test :refer :all]))

;; Problem 173 - Intro to Destructuring 2
;; http://www.4clojure.com/problem/173

(deftest tests
  (is (= 3
         (let [[f x] [+ (range 3)]] (apply f x))
         (let [[[f x] b] [[+ 1] 2]] (f x b))
         (let [[f x] [inc 2]] (f x)))))
