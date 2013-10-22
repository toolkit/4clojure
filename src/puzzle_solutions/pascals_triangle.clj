(ns puzzle-solutions.pascals-triangle
  (:require [clojure.test :refer [is]]))

;; Problem 97 - Pascal's Traiangle
;; http://www.4clojure.com/problem/97

(def __ (fn [n]
          (-> (iterate (fn [row]
                         (map + `(0 ~@row) `(~@row 0)))
                       [1])
              (nth (dec n)))))

(is (= (__ 1) [1]))
(is (= (map __ (range 1 6))
       [     [1]
             [1 1]
             [1 2 1]
             [1 3 3 1]
             [1 4 6 4 1]]))
(is (= (__ 11)
       [1 10 45 120 210 252 210 120 45 10 1]))
