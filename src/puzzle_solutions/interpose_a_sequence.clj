(ns puzzle-solutions.interpose-a-seq
  (:require [clojure.test :refer [is]]))

;; Problem 40 - Interpose a Seq
;; http://www.4clojure.com/problem/40

(def __ #(rest (interleave (repeat %) %2)))

(is (= (__ 0 [1 2 3]) [1 0 2 0 3]))
(is (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three"))
(is (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))
