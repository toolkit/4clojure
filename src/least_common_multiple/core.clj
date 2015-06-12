(ns least-common-multiple.core
  (:require [clojure.test :refer :all]))

;; Problem 100 - Least Common Multiple
;; http://www.4clojure.com/problem/100

(def __ (fn [& xs]
          (letfn [(gcd [a b]
                    (let [x (max a b)
                          y (min a b)]
                      (if (= x y)
                        x
                        (gcd (- x y) y))))
                  (lcm [a b] (/ (* a b) (gcd a b)))]
            (reduce lcm xs))))

(deftest tests
  (is (= (__ 2 3) 6))
  (is (= (__ 5 3 7) 105))
  (is (= (__ 1/3 2/5) 2))
  (is (= (__ 3/4 1/6) 3/2))
  (is (= (__ 7 5/7 2 3/5) 210)))
