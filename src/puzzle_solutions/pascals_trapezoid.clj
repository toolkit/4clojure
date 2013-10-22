(ns puzzle-solutions.pascals-trapezoid
  (:require [clojure.test :refer [is]]))

;; Problem 147 - Pascal's Trapezoid
;; http://www.4clojure.com/problem/147

(def __ (fn [c]
          (iterate (fn [x]
                     (map #(apply +' %) (partition 2 1 (concat [0] x [0])))) c)))

(is (= (second (__ [2 3 2])) [2 5 5 2]))
(is (= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]]))
(is (= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]]))
(is (= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2])))))
