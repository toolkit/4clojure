(ns double-down.core
  (:require [clojure.test :refer :all]))

;; Problem 15 - Double Down
;; http://www.4clojure.com/problem/15

(def __ #(* 2 %))

(deftest tests
  (is (= (__ 2) 4))
  (is (= (__ 3) 6))
  (is (= (__ 11) 22))
  (is (= (__ 7) 14)))
