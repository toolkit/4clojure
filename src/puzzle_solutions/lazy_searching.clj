(ns puzzle-solutions.lazy-searching
  (:require [clojure.test :refer [is]]))

;; Problem 108 - Lazy Searching
;; http://www.4clojure.com/problem/108

(def __ (fn [ & seqs ]
          (loop [s seqs]
            (let [f (map first s)
                  v (apply max f)]
              (if (every? #(= % v) f)
                v
                (recur (map (fn [i] (drop-while #(< % v) i)) s)))))))

(is (= 3 (__ [3 4 5])))
(is (= 4 (__ [1 2 3 4 5 6 7] [0.5 3/2 4 19])))
(is (= 7 (__ (range) (range 0 100 7/6) [2 3 5 7 11 13])))
(is (= 64 (__ (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20))) ;; at least as large as 20)
