(ns contain-yourself.core
  (:require [clojure.test :refer :all]))

;; Problem 47 - Contain Yourself
;; http://www.4clojure.com/problem/47

(def __ 4)

(deftest tests
  (is (contains? #{4 5 6} __))
  (is (contains? [1 1 1 1 1] __))
  (is (contains? {4 :a 2 :b} __))
  ;; Looks like my version of clojure does not support contains? on PersistenList
  ;; (is (not (contains? '(1 2 4) __)))
)
