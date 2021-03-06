(ns prime-numbers.core
  (:require [clojure.test :refer :all]))

;; Problem 67 - Prime Numbers
;; http://www.4clojure.com/problem/67

(def __
  (fn [y]
    (take y
      (filter
        (fn [x] (not-any? zero? (map #(mod x %) (range 2 x))))
        (iterate inc 2)))))

(deftest tests
  (is (= (__ 2) [2 3]))
  (is (= (__ 5) [2 3 5 7 11]))
  (is (= (last (__ 100)) 541)))
