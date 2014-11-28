(ns puzzle-solutions.count-a-sequence
  (:require [clojure.test :refer [is]]))

;; Problem 22 - Count a Sequence
;; http://www.4clojure.com/problem/22

(def __ (fn [s]
  (loop [x (seq s)
         l 0]
    (if-not (seq? x)
      l
      (recur (next x) (inc l))))))

(is (= (__ '(1 2 3 3 1)) 5))
(is (= (__ "Hello World") 11))
(is (= (__ [[1 2] [3 4] [5 6]]) 3))
(is (= (__ '(13)) 1))
(is (= (__ '(:a :b :c)) 3))
