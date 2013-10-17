(ns puzzle-solutions.longest-sequence)

;; Problem 53 - Longest sequence
;; http://www.4clojure.com/problem/53

(defn longest-sequence [c]
  (let [increasing (fn [p] (every? true? (map = p (iterate inc (first p)))))
           candidates (for [x (rseq (vec (range 2 (inc (count c)))))
                        :let [y (partition x 1 c)
                              z (filter increasing y)]
                        :when (not-empty z)] z)]
    (if-let [longest (ffirst candidates)]
      longest
      [])))

(print (longest-sequence [1 2 3 4 6 7 8 9 10 7 8 9 7]))
