(ns set-intersection
  (:require [clojure.test :refer :all]))

;; Problem 81 - Set Intersection
;; http://www.4clojure.com/problem/81

(def __ (fn [set1 set2]
          (into #{} (filter (partial contains? set1) set2))))

(is (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3}))
(is (= (__ #{0 1 2} #{3 4 5}) #{}))
(is (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))
