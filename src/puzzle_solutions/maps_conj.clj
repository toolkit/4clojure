(ns puzzle-solutions.maps-conj
  (:require [clojure.test :refer [is]]))

;; Problem 11 - Maps Conj
;; http://www.4clojure.com/problem/11

(def __ [:b 2])

(is (= {:a 1, :b 2, :c 3} (conj {:a 1} __ {:c 3})))
