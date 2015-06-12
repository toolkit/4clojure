(ns intro-to-iterate.core
  (:require [clojure.test :refer :all]))

;; Problem 45 - Intro to Iterate
;; http://www.4clojure.com/problem/45

(def __ [1 4 7 10 13])

(deftest tests
  (is (= __ (take 5 (iterate #(+ 3 %) 1)))))
