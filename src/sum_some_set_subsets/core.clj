(ns  sum-some-set-subsets.core
  (:require [clojure.set]
            [clojure.test :refer :all]))

;; Problem 131 - Sum some set subsets
;; http://www.4clojure.com/problem/131

(def __
  (fn summations [ & sets ]
    (letfn [(powerset [s]
              (reduce (fn [ps x]
                        (reduce (fn [ps s]
                                  (conj ps (conj s x))) ps ps)) #{#{}} s))
            (summations [s]
              (set (map (partial apply +) (set (filter #(> (count %) 0) (powerset s))))))]
      (not (empty? (apply clojure.set/intersection (map summations sets)))))))

(deftest tests
  (is (= true  (__ #{-1 1 99}
                   #{-2 2 888}
                   #{-3 3 7777}))) ; ex. all sets have a subset which sums to zero
  (is (= false (__ #{1}
                   #{2}
                   #{3}
                   #{4})))
  (is (= true  (__ #{1})))
  (is (= false (__ #{1 -3 51 9}
                   #{0}
                   #{9 2 81 33})))
  (is (= true  (__ #{1 3 5}
                   #{9 11 4}
                   #{-3 12 3}
                   #{-3 4 -2 10})))
  (is (= false (__ #{-1 -2 -3 -4 -5 -6}
                   #{1 2 3 4 5 6 7 8 9})))
  (is (= true  (__ #{1 3 5 7}
                   #{2 4 6 8})))
  (is (= true  (__ #{-1 3 -5 7 -9 11 -13 15}
                   #{1 -3 5 -7 9 -11 13 -15}
                   #{1 -1 2 -2 4 -4 8 -8})))
  (is (= true  (__ #{-10 9 -8 7 -6 5 -4 3 -2 1}
                   #{10 -9 8 -7 6 -5 4 -3 2 -1}))))
