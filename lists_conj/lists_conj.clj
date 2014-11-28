(ns lists-conj
  (:require [clojure.test :refer [is]]))

;; Problem 5 - Lists Conj
;; http://www.4clojure.com/problem/5

(def __ '(1 2 3 4))

(is (= __ (conj '(2 3 4) 1)))
(is (= __ (conj '(3 4) 2 1)))
