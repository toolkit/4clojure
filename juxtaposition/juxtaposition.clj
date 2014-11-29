(ns juxtaposition
  (:require [clojure.test :refer :all]))

;; Problem 59 - Juxtaposition
;; http://www.4clojure.com/problem/59

(def __ (fn [& fs]
          (fn [& as] (map #(apply % as) fs))))

(is (= [21 6 1] ((__ + max min) 2 3 5 1 6 4)))
(is (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello")))
(is (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})))
