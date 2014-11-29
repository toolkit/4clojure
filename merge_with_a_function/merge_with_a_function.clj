(ns merge-with-a-function
  (:require [clojure.test :refer :all]))

;; Problem 69 - Merge With A Function
;; http://www.4clojure.com/problem/69

(def __ (fn [f m & ms]
          (reduce (fn [a [k v]]
                    (assoc a k
                           (if (contains? a k)
                             (f (get a k) v)
                             v))) m (mapcat seq ms))))

(is (= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
       {:a 4, :b 6, :c 20}))
(is (= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
       {1 7, 2 10, 3 15}))
(is (= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
       {:a [3 4 5], :b [6 7], :c [8 9]}))
