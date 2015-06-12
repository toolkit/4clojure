(ns universal-computation-engine.core
  (:require [clojure.test :refer :all]))

;; Problem 121 - Universal Computation Engine
;; http://www.4clojure.com/problem/121

(def __ (fn [tree]
          (fn [m]
            (let [m (merge m {'/ / '* * '+ + '- -})]
              (clojure.walk/postwalk
               (fn [node]
                 (cond
                  (contains? m node) (node m)
                  (list? node) (apply (first node) (rest node))
                  :else node)) tree)))))

(deftest tests
  (is (= 2 ((__ '(/ a b))
            '{b 8 a 16})))
  (is (= 8 ((__ '(+ a b 2))
            '{a 2 b 4})))
  (is (= [6 0 -4]
         (map (__ '(* (+ 2 a)
                      (- 10 b)))
              '[{a 1 b 8}
                {b 5 a -2}
                {a 2 b 11}])))
  (is (= 1 ((__ '(/ (+ x 2)
                    (* 3 (+ y 1))))
            '{x 4 y 1}))))
