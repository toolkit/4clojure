(ns partition-a-sequence
  (:require [clojure.test :refer [is]]))

;; Problem 54 - Partition a Sequence
;; http://www.4clojure.com/problem/54

(def __(fn [n s]
         (loop [in s out []]
           (if (> n (count in))
             out
             (recur (drop n in) (conj out (take n in)))))))

(is (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
(is (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
(is (= (__ 3 (range 8)) '((0 1 2) (3 4 5))))
