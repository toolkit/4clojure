(ns advanced-destructuring
  (:require [clojure.test :refer :all]))

;; Problem 51 - Advanced Destructuring
;; http://www.4clojure.com/problem/51

(def __ [1 2 3 4 5])

(deftest tests
  (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))))
