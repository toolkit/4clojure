(ns puzzle-solutions.identify-keys-and-values
  (:require [clojure.test :refer [is]]))

;; Problem 105 - Identify Keys and Values
;; http://www.4clojure.com/problem/105

(def __ (fn [coll]
          (dissoc (reduce
                   (fn [accum item]
                     (if (keyword? item)
                       (assoc accum :seen item item [])
                       (update-in accum [(:seen accum)] #(conj % item)))) {} coll) :seen)))

(is (= {} (__ [])))
(is (= {:a [1]} (__ [:a 1])))
(is (= {:a [1], :b [2]} (__ [:a 1, :b 2])))
(is (= {:a [1 2 3], :b [], :c [4]} (__ [:a 1 2 3 :b :c 4])))
