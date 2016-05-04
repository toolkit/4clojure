(ns power-set.core
  (:require [clojure.test :refer :all]))

;; Problem 85 - Power Set
;; http://www.4clojure.com/problem/85

(def __
  (fn [s]
    (reduce (fn [ps x]
              (reduce (fn [ps s]
                        (conj ps (conj s x))) ps ps)) #{#{}} s)))

(comment "explanation of the solution above"
         (defn powerset [initial-set]
           (reduce (fn [the-current-powerset element]
                     (println "current powerset:" the-current-powerset " element: " element)
                     (reduce (fn [the-current-set the-set]
                               (conj the-current-set (conj the-set element)))
                             the-current-powerset
                             the-current-powerset))
                   #{#{}}
                   initial-set))

         (def __ powerset))

(deftest tests
  (is (= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}}))
  (is (= (__ #{}) #{#{}}))
  (is (= (__ #{1 2 3})
         #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}))
  (is (= (count (__ (into #{} (range 10)))) 1024)))
