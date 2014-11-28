(ns trees-into-tables
  (:require [clojure.test :refer [is]]))

;; Problem 146 - Trees into tables
;; http://www.4clojure.com/problem/146

(def __ #(into {} (for [[a b] % [c d] b] [[a c] d])))

(is (= (__ '{a {p 1, q 2}
             b {m 3, n 4}})
       '{[a p] 1, [a q] 2
         [b m] 3, [b n] 4}))
(is (= (__ '{[1] {a b c d}
             [2] {q r s t u v w x}})
       '{[[1] a] b, [[1] c] d,
         [[2] q] r, [[2] s] t,
         [[2] u] v, [[2] w] x}))
(is (= (__ '{m {1 [a b c] 3 nil}})
       '{[m 1] [a b c], [m 3] nil}))
