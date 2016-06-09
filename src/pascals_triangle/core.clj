(ns pascals-triangle.core
  (:require [clojure.test :refer :all]))

;; Problem 97 - Pascal's Traiangle
;; http://www.4clojure.com/problem/97

(def __ (fn [n]
          (nth (iterate #(map + `(0 ~@%) `(~@% 0)) [1]) (dec n))))

(comment
  "A solution using partition"
  (def __ (fn [n]
                   (nth
                     (iterate #(map (fn [[a b]] (+ a b)) (partition 2 1 (cons 0 (conj (vec %) 0)))) [1]) (dec n)))))

(comment
  "A solution using the wikipedia approach for calculating a row directly
  https://en.wikipedia.org/wiki/Pascal%27s_triangle#Calculating_a_row_or_diagonal_by_itself"
  (def __ (fn [n] (let [fracs (map #(/ (- n %) %) (range 1 n))]
                    (reduce (fn [accum item] (conj accum (int (* (last accum) item)))) [1] fracs)))))

(deftest tests
  (is (= (__ 1) [1]))
  (is (= (map __ (range 1 6))
         [[1]
          [1 1]
          [1 2 1]
          [1 3 3 1]
          [1 4 6 4 1]]))
  (is (= (__ 11)
         [1 10 45 120 210 252 210 120 45 10 1])))
