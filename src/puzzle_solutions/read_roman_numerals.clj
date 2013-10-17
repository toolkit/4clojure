(ns puzzle-solutions.read-roman-numerals)

;; Problem 92 - Read Roman Numerals
;; http://www.4clojure.com/problem/92

(fn [n]
  (let [ks ["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]
        vs [1000 900 500 400 100 90 50 40 10 9 5 4 1]
        roman (zipmap ks vs)
        pattern (re-pattern (apply str (interpose "|" ks)))]
    (apply + (map roman (re-seq pattern n)))))

(defn read-roman [s]
  (let [ks ["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]
        vs [1000 900 500 400 100 90 50 40 10 9 5 4 1]
        roman (zipmap ks vs)
        pattern (re-pattern (apply str (interpose "|" ks)))]
    (apply + (map roman (re-seq pattern s)))))

(read-roman "MCMLXXXIV")
(read-roman "MMXIII")
(read-roman "MCMLXXI")
(read-roman "MCMXLV")
