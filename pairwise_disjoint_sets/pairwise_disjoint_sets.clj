(ns pairwise-disjoint-sets
   (:require [clojure.test :refer :all]))

;; Problem 153 - Pairwise disjoint sets
;; http://www.4clojure.com/problem/153

(def __ #(->> (apply concat %) (apply distinct?)))

(deftest tests
  (is (= (__ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}}) true))
  (is (= (__ #{#{:a :b :c :d :e}
               #{:a :b :c :d}
               #{:a :b :c}
               #{:a :b}
               #{:a}})
         false))
  (is (= (__ #{#{[1 2 3] [4 5]}
               #{[1 2] [3 4 5]}
               #{[1] [2] 3 4 5}
               #{1 2 [3 4] [5]}})
         true))
  (is (= (__ #{#{'a 'b}
               #{'c 'd 'e}
               #{'f 'g 'h 'i}
               #{''a ''c ''f}})
         true))
  (is (= (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
               #{#{:x :y :z} #{:x :y} #{:z} #{}}
               #{'[:x :y :z] [:x :y] [:z] [] {}}})
         false))
  (is (= (__ #{#{(= "true") false}
               #{:yes :no}
               #{(class 1) 0}
               #{(symbol "true") 'false}
               #{(keyword "yes") ::no}
               #{(class '1) (int \0)}})
         false))
  (is (= (__ #{#{distinct?}
               #{#(-> %) #(-> %)}
               #{#(-> %) #(-> %) #(-> %)}
               #{#(-> %) #(-> %) #(-> %)}})
         true))
  (is (= (__ #{#{(#(-> *)) + (quote mapcat) #_ nil}
               #{'+ '* mapcat (comment mapcat)}
               #{(do) set contains? nil?}
               #{, , , #_, , empty?}})
         false)))
