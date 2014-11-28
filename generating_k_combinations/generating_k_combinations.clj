(ns generating-k-combinations
  (:require [clojure.test :refer :all]))

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

(def __ (fn [k s]
          (letfn [(powerset [s]
                    (reduce (fn [ps x]
                              (reduce (fn [ps s]
                                        (conj ps (conj s x))) ps ps)) #{#{}} s))]
            (set (filter #(= k (count %)) (powerset s))))))

(deftest tests
  (is (= (__ 1 #{4 5 6}) #{#{4} #{5} #{6}}))
  (is (= (__ 10 #{4 5 6}) #{}))
  (is (= (__ 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}}))
  (is (= (__ 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                               #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}}))
  (is (= (__ 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}}))
  (is (= (__ 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                            #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})))
