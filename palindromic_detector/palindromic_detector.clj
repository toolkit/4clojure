(ns palindromic-detector
  (:require [clojure.test :refer [is]]))

;; Problem 27 - Palindromic Detector
;; http://www.4clojure.com/problem/27

(def __ #(= (reverse (seq %)) (seq %)))

(is (false? (__ '(1 2 3 4 5))))
(is (true? (__ "racecar")))
(is (true? (__ [:foo :bar :foo])))
(is (true? (__ '(1 1 3 3 1 1))))
(is (false? (__ '(:a :b :c))))
