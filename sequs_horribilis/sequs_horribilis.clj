(ns sequs-horribilis
  (:require [clojure.test :refer :all]))

;; Problem 112 - Sequs Horribilis
;; http://www.4clojure.com/problem/112

(def __ (fn take-until [n vals]
  (loop [values vals
         current 0
         accum []]
    (if (empty? values)
      accum
      (let [v (first values)]
        (if (coll? v)
          (let [sub (take-until (- n current) v)]
                (let [total (+ current (reduce + (flatten sub)))]
                  (recur (rest values) total (conj accum sub))))
          (let [total (+ current v)]
                (if (> total n)
                  accum
                  (recur (rest values) total (conj accum v))))))))))

(deftest tests
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
          '(-10 (1 (2 3 (4)))))))
