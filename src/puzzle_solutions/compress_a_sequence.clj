(ns puzzle-solutions.compress-a-sequence
  (:require [clojure.test :refer [is]]))

;; Problem 30 - Compress A Sequence
;; http://www.4clojure.com/problem/30

(def __ #(map first (partition-by identity %)))

(is (= (apply str (__ "Leeeeeerrroyyy")) "Leroy"))
(is (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
(is (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))
