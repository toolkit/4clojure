(ns global-take-while.core
  (:require [clojure.test :refer :all]))

;; Problem 114 - Global take while
;; http://www.4clojure.com/problem/114

(def __
  (fn gtw
    ([n pred coll] (gtw n pred coll 0))
    ([n pred coll matched]
     (let [item (first coll)]
       (when item
         (let [matched (if (pred item) (inc matched) matched)]
           (when (< matched n)
             (lazy-seq (cons item (gtw n pred (rest coll) matched))))))))))

(deftest tests
  (is (= [2 3 5 7 11 13]
         (__ 4 #(= 2 (mod % 3))
             [2 3 5 7 11 13 17 19 23])))
  (is (= [2 3 5 7 11 13 17 19 23]
         (__ 4 #(= 0 (mod % 71))
             [2 3 5 7 11 13 17 19 23])))
  (is (= ["this" "is" "a" "sentence"]
         (__ 3 #(some #{\i} %)
             ["this" "is" "a" "sentence" "i" "wrote"])))
  (is (= ["this" "is"]
         (__ 1 #{"a"}
             ["this" "is" "a" "sentence" "i" "wrote"]))))
