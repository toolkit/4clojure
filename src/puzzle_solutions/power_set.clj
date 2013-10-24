(ns puzzle-solutions.power-set
  (:require [clojure.test :refer [is]]))

;; Problem 85 - Power Set
;; http://www.4clojure.com/problem/85

(def __
  (fn [s]
    (reduce (fn [ps x]
              (reduce (fn [ps s]
                        (conj ps (conj s x))) ps ps)) #{#{}} s)))


(is (= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}}))
(is (= (__ #{}) #{#{}}))
(is (= (__ #{1 2 3})
       #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}))
(is (= (count (__ (into #{} (range 10)))) 1024))
