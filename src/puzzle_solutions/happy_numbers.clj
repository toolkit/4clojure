(ns puzzle-solutions.happy-numbers)

;; Problem 86 - Happy numbers
;; http://www.4clojure.com/problem/86

(defn happy [x]
  (letfn [(sumsq [y] (reduce + (map #(* % %) (map #(- (int %) 48) (str y)))))]
    (loop [z (sumsq x)
           seen #{}]
      (comment (printf "%d, %s\n" z seen))
      (cond
        (seen z) false
        (= 1 z) true
        :else (recur (sumsq z) (conj seen z))))))

(take 10 (drop 20 (filter happy (range))))
