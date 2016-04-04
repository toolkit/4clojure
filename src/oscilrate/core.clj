(ns oscilrate.core
   (:require [clojure.test :refer :all]))

;; Problem 144 - Oscilrate
;; http://www.4clojure.com/problem/144

(def __ (fn [x & fs]
          (reductions #(%2 %1) x (cycle fs))))

(deftest tests
  (is (= (take 3 (__ 3.14 int double)) [3.14 3 3.0]))
  (is (= (take 5 (__ 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7]))
  (is (= (take 12 (__ 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])))
