(ns a-nil-key
  (:require [clojure.test :refer [is]]))

;; Problem 134 - A nil key
;; http://www.4clojure.com/problem/134

(def __ #(nil? (%1 %2 :not-found)))

(is (true?  (__ :a {:a nil :b 2})))
(is (false? (__ :b {:a nil :b 2})))
(is (false? (__ :c {:a nil :b 2})))
