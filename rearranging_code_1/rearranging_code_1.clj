(ns rearranging-code-1
  (:require [clojure.test :refer :all]))

;; Problem 71 - Rearranging Code: ->
;; http://www.4clojure.com/problem/71

(def __ last)

(is (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
       (-> [2 5 4 1 3 6] reverse rest sort __)
       5))
