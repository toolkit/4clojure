(ns intro-to-functions
  (:require [clojure.test :refer :all]))

;; Problem 14 - Intro to Functions
;; http://www.4clojure.com/problem/14

(def __ 8)

(deftest tests
  (is (= __ ((fn add-five [x] (+ x 5)) 3)))
  (is (= __ ((fn [x] (+ x 5)) 3)))
  (is (= __ (#(+ % 5) 3)))
  (is (= __ ((partial + 5) 3))))
