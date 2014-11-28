(ns intervals
  (:require [clojure.test :refer [is]]))

;; Problem 171 - Intervals
;; http://www.4clojure.com/problem/171

(def __ (fn [a]
          (let [a (sort (set a))
                mi (map-indexed #(vector % %2) a)
                vs (vals (group-by #(apply - %) mi))
                is (map #(vector (last (first %)) (last (last %))) vs)]
            is)))


(is (= (__ [1 2 3]) [[1 3]]))
(is (= (__ [10 9 8 1 2 3]) [[1 3] [8 10]]))
(is (= (__ [1 1 1 1 1 1 1]) [[1 1]]))
(is (= (__ []) []))
(is (= (__ [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
       [[1 4] [6 6] [9 11] [13 17] [19 19]]))
