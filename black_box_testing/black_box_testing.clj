(ns black-box-testing
  (:require [clojure.test :refer :all]))

;; Problem 65 - Black box testing
;; http://www.4clojure.com/problem/65

(def __ #(cond
  (reversible? %) :vector
  (associative? %) :map
  (= % (apply list %)) :list
  :else :set))

(deftest tests
  (is (= :map (__ {:a 1, :b 2})))
  (is (= :list (__ (range (rand-int 20)))))
  (is (= :vector (__ [1 2 3 4 5 6])))
  (is (= :set (__ #{10 (rand-int 5)})))
  (is (= [:map :set :vector :list] (map __ [{} #{} [] ()]))))
