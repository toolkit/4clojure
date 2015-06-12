(ns re-implement-trampoline.core
  (:require [clojure.test :refer :all]))

;; Problem 78 - Reimplement Trampoline
;; http://www.4clojure.com/problem/78

(def __ #(loop [res (apply % %&)]
           (if (fn? res)
             (recur (res)) res)))

(deftest tests
  (is (= (letfn [(triple [x] #(sub-two (* 3 x)))
                 (sub-two [x] #(stop?(- x 2)))
                 (stop? [x] (if (> x 50) x #(triple x)))]
           (__ triple 2))
         82))
  (is (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
                 (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
           (map (partial __ my-even?) (range 6)))
         [true false true false true false])))
