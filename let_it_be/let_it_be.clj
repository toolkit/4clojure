(ns puzzle-solutions.let-it-be
  (:require [clojure.test :refer [is]]))

;; Problem 36 - Let it Be
;; http://www.4clojure.com/problem/36

(is (= 10 (let [z 1
                y 3
                x 7] (+ x y))))
(is (= 4 (let [z 1
               y 3
               x 7] (+ y z))))
(is (= 1 (let [z 1
               y 3
               x 7] z)))
