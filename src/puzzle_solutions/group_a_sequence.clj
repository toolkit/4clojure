(ns puzzle-solutions.group-a-sequence
  (:require [clojure.test :refer [is]]))

;; Problem 63 - Group a Sequence
;; http://www.4clojure.com/problem/63

(def __ #(apply merge-with into
                (for [x %2]
                  {(% x) [x]})))

(is (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
(is (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
       {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
(is (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
       {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}))
