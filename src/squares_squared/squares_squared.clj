(ns puzzle-solutions.squares-squared)

;; TO DO - Still to solve

;; Problem 138 - Squares Squared
;; http://www.4clojure.com/problem/138

(defn prange [x y]
  (take-while #(<= % y) (iterate #(* % %) x)))

(prange 4 20)

(count (apply str (prange 10 10000)))

(defn required-size [s]
  (first (drop-while #(> (count s) %) (map #(* % %) (range)))))

(required-size "1010010000")
