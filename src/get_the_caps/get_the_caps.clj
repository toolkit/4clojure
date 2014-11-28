(ns puzzle-solutions.get-the-caps
  (:require [clojure.test :refer [is]]))

;; Problem 29 - Get the Caps
;; http://www.4clojure.com/problem/29

(def __ #(apply str (re-seq  #"\p{Upper}" %)))

(is (= (__ "HeLlO, WoRlD!") "HLOWRD"))
(is (empty? (__ "nothing")))
(is (= (__ "$#A(*&987Zf") "AZ"))
