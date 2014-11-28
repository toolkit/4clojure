(ns for-the-win
  (:require [clojure.test :refer :all]))

;; Problem 145 - For the Win
;; http://www.4clojure.com/problem/145

(def __ [1 5 9 13 17 21 25 29 33 37])

(deftest tests
  (is (= __ (for [x (range 40)
                  :when (= 1 (rem x 4))]
              x)))
  (is (= __ (for [x (iterate #(+ 4 %) 0)
                  :let [z (inc x)]
                  :while (< z 40)]
              z)))
  (is (= __ (for [[x y] (partition 2 (range 20))]
              (+ x y)))))
