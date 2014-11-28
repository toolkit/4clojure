(ns intro-to-iterate
  (:require [clojure.test :refer [is]]))

;; Problem 45 - Intro to Iterate
;; http://www.4clojure.com/problem/45

(def __ [1 4 7 10 13])

(is (= __ (take 5 (iterate #(+ 3 %) 1))))
