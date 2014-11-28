(ns through-the-looking-glass
  (:require [clojure.test :refer :all]))

;; Problem 126 - Through the looking glass
;; http://www.4clojure.com/problem/126

(def __ Class)

(deftest tests
  (let [x __]
    (is x (and (= (class x) x) x))))
