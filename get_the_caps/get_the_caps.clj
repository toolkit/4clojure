(ns get-the-caps
  (:require [clojure.test :refer :all]))

;; Problem 29 - Get the Caps
;; http://www.4clojure.com/problem/29

(def __ #(apply str (re-seq  #"\p{Upper}" %)))

(deftest tests
  (is (= (__ "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (__ "nothing")))
  (is (= (__ "$#A(*&987Zf") "AZ")))
