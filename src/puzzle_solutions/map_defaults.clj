(ns puzzle-solutions.map-defaults
  (:require [clojure.test :refer [is]]))

;; Problem 156 - Map Defaults
;; http://www.4clojure.com/problem/156

(def __ #(into {} (for [x %2] [x %1])))

(is (= (__ 0 [:a :b :c]) {:a 0 :b 0 :c 0}))
(is (= (__ "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}))
(is (= (__ [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}))
