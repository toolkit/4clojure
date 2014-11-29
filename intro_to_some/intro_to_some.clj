(ns intro-to-some
  (:require [clojure.test :refer :all]))

;; Problem 48 - Intro to Some
;; http://www.4clojure.com/problem/48

(def __ 6)

(deftest tests
  (is (= __ (some #{2 7 6} [5 6 7 8])))
  (is (= __ (some #(when (even? %) %) [5 6 7 8]))))
