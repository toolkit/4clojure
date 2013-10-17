(ns puzzle-solutions.black-box-testing
  (:require [clojure.test :refer [is]]))

;; Problem 58 - function composition
;; http://www.4clojure.com/problem/58

(def __ (fn [& fs]
          (reduce (fn [f g]
                    #(f (apply g %&))) fs)))


(is (= [3 2 1] ((__ rest reverse) [1 2 3 4])))
(is (= 5 ((__ (partial + 3) second) [1 2 3 4])))
(is (= true ((__ zero? #(mod % 8) +) 3 5 7 9)))
(is (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world")))
