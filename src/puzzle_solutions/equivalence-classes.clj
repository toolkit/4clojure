(ns puzzle-solutions.equivalence-classes
  (:require [clojure.test :refer [is]]))

;; Problem 32 - Duplicate a Sequence
;; http://www.4clojure.com/problem/32

(def __ (fn [f D]
          (set (map (comp set val) (group-by f D)))))

(is (= (__ #(* % %) #{-2 -1 0 1 2})
       #{#{0} #{1 -1} #{2 -2}}))

(is (= (__ #(rem % 3) #{0 1 2 3 4 5 })
       #{#{0 3} #{1 4} #{2 5}}))

(is (= (__ identity #{0 1 2 3 4})
       #{#{0} #{1} #{2} #{3} #{4}}))

(is (= (__ (constantly true) #{0 1 2 3 4})
       #{#{0 1 2 3 4}}))
