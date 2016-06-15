(ns  symmetric-difference.core
  (:require [clojure.test :refer :all]))

;; Problem 88 - Symmetric Difference
;; http://www.4clojure.com/problem/88

(def __ #(set (concat (remove %2 %)
                      (remove % %2))))

(deftest tests
  (is (= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
  (is (= (__ #{:a :b :c} #{}) #{:a :b :c}))
  (is (= (__ #{} #{4 5 6}) #{4 5 6}))
  (is (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})))
