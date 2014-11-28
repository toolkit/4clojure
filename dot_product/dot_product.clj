(ns dot-product
  (:require [clojure.test :refer :all]))

;; Problem 143 - Dot Product
;; http://www.4clojure.com/problem/143

(def __ #(reduce + (apply map * %&)))

(deftest tests
  (is (= 0 (__ [0 1 0] [1 0 0])))
  (is (= 3 (__ [1 1 1] [1 1 1])))
  (is (= 32 (__ [1 2 3] [4 5 6])))
  (is (= 256 (__ [2 5 6] [100 10 1]))))
