(ns word-sorting.core
  (:require [clojure.test :refer :all]))

;; Problem 70 - Word Sorting
;; http://www.4clojure.com/problem/70

(def __ (fn [s] (sort-by #(.toLowerCase %) (re-seq #"\w+" s))))

(deftest tests
  (is (= (__  "Have a nice day.")
         ["a" "day" "Have" "nice"]))
  (is (= (__  "Clojure is a fun language!")
         ["a" "Clojure" "fun" "is" "language"]))
  (is (= (__  "Fools fall for foolish follies.")
         ["fall" "follies" "foolish" "Fools" "for"])))
