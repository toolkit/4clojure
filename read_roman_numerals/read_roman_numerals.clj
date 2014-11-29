(ns read-roman-numerals
  (:require [clojure.test :refer :all]))

;; Problem 92 - Read Roman Numerals
;; http://www.4clojure.com/problem/92

(def __
  (fn [x]
    (let [ks ["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]
          vs [1000 900 500 400 100 90 50 40 10 9 5 4 1]
          roman (zipmap ks vs)
          pattern (re-pattern (apply str (interpose "|" ks)))]
      (apply + (map roman (re-seq pattern x))))))

(is (= 14 (__ "XIV")))
(is (= 827 (__ "DCCCXXVII")))
(is (= 3999 (__ "MMMCMXCIX")))
(is (= 48 (__ "XLVIII")))
