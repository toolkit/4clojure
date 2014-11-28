(ns intro-to-sets
  (:require [clojure.test :refer [is]]))

;; Problem 8 - Intro to Sets
;; http://www.4clojure.com/problem/8

(def __ #{:a :b :c :d})

(is (= __ (set '(:a :a :b :c :c :c :c :d :d))))
(is (= __ (clojure.set/union #{:a :b :c} #{:b :c :d})))
