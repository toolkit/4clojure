(ns puzzle-solutions.sum-some-set-subsets)

;; Problem 131 - Sum some set subsets
;; http://www.4clojure.com/problem/131

(defn summations [ & sets ]
  (letfn [(powerset [s]
            (reduce (fn [ps x]
                      (reduce (fn [ps s]
                                (conj ps (conj s x))) ps ps)) #{#{}} s))
          (summations [s]
            (set (map (partial apply +) (set (filter #(> (count %) 0) (powerset s))))))]
    (not (empty? (apply clojure.set/intersection (map summations sets))))))

(summations #{-1 1 99} #{-2 4 888})
