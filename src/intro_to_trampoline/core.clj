(ns intro-to-trampoline.core
  (:require [clojure.test :refer :all]))

;; Problem 76 - Intro to Trampoline
;; http://www.4clojure.com/problem/76

(def __ [1 3 5 7 9 11])

(deftest tests
  (is (= __
         (letfn
             [(foo [x y] #(bar (conj x y) y))
              (bar [x y] (if (> (last x) 10)
                           x
                           #(foo x (+ 2 y))))]
           (trampoline foo [] 1)))))
