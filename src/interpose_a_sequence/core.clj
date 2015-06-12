(ns interpose-a-sequence.core
  (:require [clojure.test :refer :all]))

;; Problem 40 - Interpose a Seq
;; http://www.4clojure.com/problem/40

(def __ #(rest (interleave (repeat %) %2)))

(deftest tests
  (is (= (__ 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three"))
  (is (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))
