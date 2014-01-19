(ns puzzle-solutions.sequs-horribilis
  (:require [clojure.test :refer [is]]))

;; TODO

;; Problem 112 - Sequs Horribilis
;; http://www.4clojure.com/problem/112

(def __ (fn [] nil))

(is (=  (__ 10 [1 2 [3 [4 5] 6] 7])
        '(1 2 (3 (4)))))
(is (=  (__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
        '(1 2 (3 (4 (5 (6 (7))))))))
(is (=  (__ 9 (range))
        '(0 1 2 3)))
(is (=  (__ 1 [[[[[1]]]]])
        '(((((1)))))))
(is (=  (__ 0 [1 2 [3 [4 5] 6] 7])
        '()))
(is (=  (__ 0 [0 0 [0 [0]]])
        '(0 0 (0 (0)))))
(is (=  (__ 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
        '(-10 (1 (2 3 (4))))))
