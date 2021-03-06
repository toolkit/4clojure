(ns maximum-value.core
  (:require [clojure.test :refer :all]))

;; Problem 38 - Maximum Value
;; http://www.4clojure.com/problem/38

(def __ (fn [& xs]
          (reduce #(if (> %1 %2) %1 %2) xs)))

(deftest tests
  (is (= (__ 1 8 3 4) 8))
  (is (= (__ 30 20) 30))
  (is (= (__ 45 67 11) 67)))
