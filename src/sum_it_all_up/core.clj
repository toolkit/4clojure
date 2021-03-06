(ns sum-it-all-up.core
  (:require [clojure.test :refer :all]))

;; Problem 24 - Sum it all up
;; http://www.4clojure.com/problem/24

(def __ (partial reduce +))

(deftest tests
  (is (= (__ [1 2 3]) 6))
  (is (= (__ (list 0 -2 5 5)) 8))
  (is (= (__ #{4 2 1}) 7))
  (is (= (__ '(0 0 -1)) -1))
  (is (= (__ '(1 10 3)) 14)))
