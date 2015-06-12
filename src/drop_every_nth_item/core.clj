(ns drop-every-nth-item.core
  (:require [clojure.test :refer :all]))

;; Problem 41 - Drop Every Nth Item
;; http://www.4clojure.com/problem/41

(def __ #(flatten (partition-all (dec %2) %2 %1)))

(deftest tests
  (is (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
  (is (= (__ [:a :b :c :d :e :f] 2) [:a :c :e]))
  (is (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])))
