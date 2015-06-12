(ns sequence-of-pronunciations.core
  (:require [clojure.test :refer :all]))

;; Problem 110 - Sequence of Pronunciations
;; http://www.4clojure.com/problem/110

(def __ (fn [s]
          (rest (iterate #(mapcat (juxt count first) (partition-by max %)) s))))

(deftest tests
  (is (= [[1 1] [2 1] [1 2 1 1]] (take 3 (__ [1]))))
  (is (= [3 1 2 4] (first (__ [1 1 1 4 4]))))
  (is (= [1 1 1 3 2 1 3 2 1 1] (nth (__ [1]) 6)))
  (is (= 338 (count (nth (__ [3 2]) 15)))))
