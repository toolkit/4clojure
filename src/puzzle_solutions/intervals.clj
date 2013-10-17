(ns puzzle-solutions.intervals)

;; Problem 171 - Intervals
;; http://www.4clojure.com/problem/171

((fn [a]
  (let [a (sort (set a))
        mi (map-indexed #(vector % %2) a)
        vs (vals (group-by #(apply - %) mi))
        is (map #(vector (last (first %)) (last (last %))) vs)]
  is)) [4 3 2 1 7 8 9])
