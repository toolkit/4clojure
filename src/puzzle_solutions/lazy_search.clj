(ns puzzle-solutions.lazy-search)

;; Problem 108 - Lazy Search
;; http://www.4clojure.com/problem/108

(defn tw [ & seqs ]
  (loop [s seqs]
    (let [f (map first s)
          v (apply max f)]
      (if (every? #(= v %) f)
        v
        (recur (map (fn [i] (drop-while #(< % v) i)) s))))))

(tw (range 1 10) (range 0 10) [3 4 5])
