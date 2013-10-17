(ns puzzle-solutions.powerset)

;; Problem 85 - Powerset
;; http://www.4clojure.com/problem/85

(defn powerset [s]
  (reduce (fn [ps x]
            (reduce (fn [ps s]
                      (conj ps (conj s x))) ps ps)) #{#{}} s))

(powerset #{1 2 3 4})
