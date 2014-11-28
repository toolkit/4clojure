(ns puzzle-solutions.local-bindings
  (:require [clojure.test :refer [is]]))

;; Problem 35 - Local Bindings
;; http://www.4clojure.com/problem/35

(def __ 7)

(is (= __ (let [x 5] (+ 2 x))))
(is (= __ (let [x 3, y 10] (- y x))))
(is (= __ (let [x 21] (let [y 3] (/ x y)))))
