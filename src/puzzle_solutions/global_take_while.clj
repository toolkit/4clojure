(ns puzzle-solutions.global-take-while)

;; Problem 114 - Global take while
;; http://www.4clojure.com/problem/114

(defn gtw [n p s]
   (take
     (last
       (take n (keep-indexed #(if (p %2) %) s)))
     s))

(gtw 4 #(= 2 (mod % 3))
  [2 3 5 7 11 13 17 19 23])

(gtw 3 #(some #{\i} %)
  ["this" "is" "a" "sentence" "i" "wrote"])
