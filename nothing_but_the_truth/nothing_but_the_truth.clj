(ns nothing-but-the-truth
  (:require [clojure.test :refer :all]))

;; Problem 1 - Nothing but the truth
;; http://www.4clojure.com/problem/1

(def __ true)

(deftest tests
  (is (= __ true)))
