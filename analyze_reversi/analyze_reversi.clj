(ns a-half-truth
  (:require [clojure.test :refer [is]]))

;; Problem 83 - A Half-Truth
;; http://www.4clojure.com/problem/83

(def __ #(and
  (not-every? true? %&)
  (not-every? false? %&)))

(is (= false (__ false false)))
(is (= true (__ true false)))
(is (= false (__ true)))
(is (= true (__ false true false)))
(is (= false (__ true true true)))
(is (= true (__ true true true false)))
