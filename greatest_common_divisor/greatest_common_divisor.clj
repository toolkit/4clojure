(ns greatest-common-divisor
  (:require [clojure.test :refer [is]]))

;; Problem 66 - Greatest Common Divisor
;; http://www.4clojure.com/problem/66

(def __ (fn [a b]
          (last
           (filter #(and (zero? (mod a %))
                         (zero? (mod b %)))
                   (range 1 (max a b))))))

(is (= (__ 2 4) 2))
(is (= (__ 10 5) 5))
(is (= (__ 5 7) 1))
(is (= (__ 1023 858) 33))
