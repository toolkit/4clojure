(ns happy-numbers
  (:require [clojure.test :refer [is]]))

;; Problem 86 - Happy numbers
;; http://www.4clojure.com/problem/86

(def __ (fn [x]
          (letfn [(sumsq [y] (reduce + (map #(* % %) (map #(- (int %) 48) (str y)))))]
            (loop [z (sumsq x)
                   seen #{}]
              (cond
               (seen z) false
               (= 1 z) true
               :else (recur (sumsq z) (conj seen z)))))))

(is (= (__ 7) true))
(is (= (__ 986543210) true))
(is (= (__ 2) false))
(is (= (__ 3) false))
