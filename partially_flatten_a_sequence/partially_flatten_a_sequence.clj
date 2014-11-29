(ns partially-flatten-a-sequence
  (:require [clojure.test :refer :all]))

;; Problem 93 - Partially Flatten a Sequence
;; http://www.4clojure.com/problem/93

(def __ (fn [x]
          (filter #(and (sequential? %)
                        (every? (complement sequential?) %))
                  (tree-seq sequential? seq x))))

(deftest tests
  (is (= (__ [["Do"] ["Nothing"]])
         [["Do"] ["Nothing"]]))
  (is (= (__ [[[[:a :b]]] [[:c :d]] [:e :f]])
         [[:a :b] [:c :d] [:e :f]]))
  (is (= (__ '((1 2)((3 4)((((5 6)))))))
         '((1 2)(3 4)(5 6)))))
