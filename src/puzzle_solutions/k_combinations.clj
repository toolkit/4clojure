(ns puzzle-solutions.k-combinations)


;; Problem 103 - K-Combinations
;; http://www.4clojure.com/problem/103

;; Totally insane way of calculcating combinations
;; (defn combinations [k s]
;;   (let [v (vec s)
;;         bit-positions
;;         (fn [n]
;;           (keep-indexed #(if (= \1 %2) %1) (reverse (Integer/toString n 2))))
;;         positions
;;         (fn [n k]
;;           (filter #(= k (count %)) (map bit-positions (range (Math/pow 2 n)))))]
;;     (set (map #(set (map v %)) (positions (count s) k)))))

(defn combinations [k s]
  (letfn [(powerset [s]
            (reduce (fn [ps x]
                      (reduce (fn [ps s]
                                (conj ps (conj s x))) ps ps)) #{#{}} s))]
        (set (filter #(= k (count %)) (powerset s)))))

(combinations 2 #{'a 'b 'c 'd})
