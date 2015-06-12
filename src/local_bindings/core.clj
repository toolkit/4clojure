(ns local-bindings.core
  (:require [clojure.test :refer :all]))

;; Problem 35 - Local Bindings
;; http://www.4clojure.com/problem/35

(def __ 7)

(deftest tests
  (is (= __ (let [x 5] (+ 2 x))))
  (is (= __ (let [x 3, y 10] (- y x))))
  (is (= __ (let [x 21] (let [y 3] (/ x y))))))
