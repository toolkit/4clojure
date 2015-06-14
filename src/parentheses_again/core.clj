(ns parentheses-again.core
  (:require [clojure.test :refer :all]))

;; Problem 195 - Parentheses .. again
;; https://www.4clojure.com/problem/195

(defn to-bits [x n]
  (map #(bit-and 1 (bit-shift-right x %)) (range (- n 1) -1 -1)))

(to-bits 2r11011011 8)

(def __ (fn [n]
          (let [ins (fn [string pos]
                      (apply str (subs string 0 pos) "()" (subs string pos)))
                each-ins (fn [string]
                           (map (partial ins string) (range 0 (inc (count string)))))
                step (fn [string-set]
                       (into #{} (flatten (map each-ins string-set))))]
            (last (take (inc n) (iterate step #{""}))))))

(deftest tests
  (is (= [#{""} #{"()"} #{"()()" "(())"}] (map (fn [n] (__ n)) [0 1 2])))
  (is (= #{"((()))" "()()()" "()(())" "(())()" "(()())"} (__ 3)))
  (is (= 16796 (count (__ 10))))
  (is (= (nth (sort (filter #(.contains ^String % "(()()()())") (__ 9))) 6) "(((()()()())(())))"))
  (is (= (nth (sort (__ 12)) 5000) "(((((()()()()()))))(()))")))