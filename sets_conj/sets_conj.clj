(ns sets-conj
  (:require [clojure.test :refer :all]))

;; Problem 9 - Sets: Conj
;; http://www.4clojure.com/problem/9

(def __ 2)

(deftest tests
  (is (= #{1 2 3 4} (conj #{1 4 3} __))))
