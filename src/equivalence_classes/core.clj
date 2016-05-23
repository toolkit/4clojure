(ns equivalence-classes.core
  (:require [clojure.test :refer :all]))

;; Problem 98 - Equivalence classes
;;
;; http://www.4clojure.com/problem/98
;;
;; A function f defined on a domain D induces an equivalence relation on D, as follows:
;; a is equivalent to b with respect to f if and only if (f a) is equal to (f b).
;; Write a function with arguments f and D that computes the equivalence classes of D with respect to f.
;;


(def __ (fn [f D]
          (set (map (comp set val) (group-by f D)))))

(deftest tests
  (is (= (__ #(* % %) #{-2 -1 0 1 2})
         #{#{0} #{1 -1} #{2 -2}}))

  (is (= (__ #(rem % 3) #{0 1 2 3 4 5 })
         #{#{0 3} #{1 4} #{2 5}}))

  (is (= (__ identity #{0 1 2 3 4})
         #{#{0} #{1} #{2} #{3} #{4}}))

  (is (= (__ (constantly true) #{0 1 2 3 4})
         #{#{0 1 2 3 4}})))
