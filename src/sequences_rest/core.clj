(ns sequences-rest.core
  (:require [clojure.test :refer :all]))

;; Problem 13 - Sequences: Rest
;; http://www.4clojure.com/problem/13

(def __ '(20 30 40))

(deftest tests
  (is (= __ (rest [10 20 30 40]))))
