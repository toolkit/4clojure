(ns puzzle-solutions.sequence-reductions)

;; Problem 60 - Sequence Reductions
;; http://www.4clojure.com/problem/60
(defn red
  ([f a] (red f (first a) (rest a)))
  ([f i a]
    (cons i
      (lazy-seq
        (when (seq a)
          (red f (f i (first a)) (rest a)))))))

(take 5 (red + (range)))
