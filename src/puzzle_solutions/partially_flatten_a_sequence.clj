(ns puzzle-solutions.partially-flatten-a-sequence)

;; Problem 93 - Partially Flatten a Sequence
;; http://www.4clojure.com/problem/93

(defn p-flatten [x]
  (filter #(and (sequential? %)
                (every? (complement sequential?) %))
          (tree-seq sequential? seq x)))

(p-flatten [["Do"] ["Nothing"]])
