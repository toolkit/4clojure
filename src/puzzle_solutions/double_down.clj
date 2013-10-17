(ns puzzle-solutions.double-down
  (:require [clojure.test :refer [is]]))

;; Problem 15 - Double Down
;; http://www.4clojure.com/problem/15

(def __ #(* 2 %))

(is (= (__ 2) 4))
(is (= (__ 3) 6))
(is (= (__ 11) 22))
(is (= (__ 7) 14))
