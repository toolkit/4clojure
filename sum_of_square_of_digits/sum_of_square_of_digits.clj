(ns sum-of-square-of-digits
  (:require [clojure.test :refer :all]))

;; Problem 120 - Sum of square of digits
;; http://www.4clojure.com/problem/120

(def __ (fn [s]
          (count
           (filter
            (fn [x]
              (let [digits (map #(- (int %) 48) (str x))
                    sum (apply + (map #(* % %) digits))]
                (< x sum))) s))))

(is (= 8 (__ (range 10))))
(is (= 19 (__ (range 30))))
(is (= 50 (__ (range 500))))
(is (= 50 (__ (range 1000))))
