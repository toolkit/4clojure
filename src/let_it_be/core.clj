(ns let-it-be.core
  (:require [clojure.test :refer :all]))

;; Problem 36 - Let it Be
;; http://www.4clojure.com/problem/36


(deftest tests
  (is (= 10 (let [z 1
                  y 3
                  x 7] (+ x y))))
  (is (= 4 (let [z 1
                 y 3
                 x 7] (+ y z))))
  (is (= 1 (let [z 1
                 y 3
                 x 7] z))))
