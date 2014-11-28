(ns sequences-rest
  (:require [clojure.test :refer [is]]))

;; Problem 13 - Sequences: Rest
;; http://www.4clojure.com/problem/13

(def __ '(20 30 40))

(is (= __ (rest [10 20 30 40])))
