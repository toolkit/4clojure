(ns flatten-a-sequence
  (:require [clojure.test :refer :all]))

;; Problem 28 - Flatten a Sequence
;; http://www.4clojure.com/problem/28

(def __ (fn f [c]
          (if (coll? c)
            (mapcat f c)
            [c])))

(deftest tests
  (is (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (is (= (__ ["a" ["b"] "c"]) '("a" "b" "c")))
  (is (= (__ '((((:a))))) '(:a))))
