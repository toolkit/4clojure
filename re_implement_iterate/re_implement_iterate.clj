(ns puzzle-solutions.re-implement-iterate
  (:require [clojure.test :refer [is]]))

;; Problem 62 - Re-implement iterate
;; http://www.4clojure.com/problem/62

(def __
  (fn it [f x]
    (cons x (lazy-seq (it f (f x))))))

(is (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16]))
(is (= (take 100 (__ inc 0)) (take 100 (range))))
(is (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))))
