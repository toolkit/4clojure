(ns rearranging-code-2
  (:require [clojure.test :refer :all]))

;; Problem 72 - Rearranging Code: ->>
;; http://www.4clojure.com/problem/72

(is (= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
       (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +))
       11))
