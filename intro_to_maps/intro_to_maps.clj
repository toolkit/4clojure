(ns puzzle-solutions.intro-to-maps
  (:require [clojure.test :refer [is]]))

;; Problem 10 - Intro to Maps
;; http://www.4clojure.com/problem/10

(def __ 20)

(is (= __ ((hash-map :a 10, :b 20, :c 30) :b)))
(is (= __ (:b {:a 10, :b 20, :c 30})))
