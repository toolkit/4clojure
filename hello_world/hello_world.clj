(ns hello-world
  (:require [clojure.test :refer :all]))

;; Problem 16 - Hello World
;; http://www.4clojure.com/problem/16

(def __ (fn [name] (str "Hello, " name "!")))

(deftest tests
  (is (= (__ "Dave") "Hello, Dave!"))
  (is (= (__ "Jenn") "Hello, Jenn!"))
  (is (= (__ "Rhea") "Hello, Rhea!")))
