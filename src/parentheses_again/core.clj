(ns parentheses-again.parentheses-again.core
  (:require [clojure.test :refer :all]))

;; Problem 195 - Parentheses .. again
;; https://www.4clojure.com/problem/195


(def __
  (fn [n]
    (let [to-bits (fn [x n]
                    (map #(bit-shift-right (bit-and x (bit-shift-left 1 %)) %)
                         (range (- n 1) -1 -1)))
          balanced (fn [bits]
                     (let [accum (take-while (complement neg?)
                                             (reductions (fn [state bit] (+ state (case bit 1 1 0 -1))) bits))]
                       (and (= (count bits) (count accum))
                            (zero? (last accum)))))
          to-parens (fn [bits] (apply str (map {1 \( 0 \)} bits)))
          max (bit-shift-left 1 (* 2 n))]
      (apply hash-set (for [x (range (/ max 2) max 2)
                            :let [bits (to-bits x (* 2 n))]
                            :when (balanced bits)]
                        [(apply str (to-parens bits)) (apply str bits) x])))))


(clojure.pprint/pprint (sort-by first (__ 4)))




(deftest tests
  ;(is (= [#{""} #{"()"} #{"()()" "(())"}] (map (fn [n] (__ n)) [0 1 2])))
  (is (= #{"((()))" "()()()" "()(())" "(())()" "(()())"} (__ 3)))
  (is (= 16796 (count (__ 10))))
  (is (= (nth (sort (filter #(.contains ^String % "(()()()())") (__ 9))) 6) "(((()()()())(())))"))
  (is (= (nth (sort (__ 12)) 5000) "(((((()()()()()))))(()))")))