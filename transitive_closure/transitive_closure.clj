(ns transitive-closure
  (:require [clojure.test :refer :all]))

;; Problem 84 - Transitive Closure
;; http://www.4clojure.com/problem/84

(def __ (fn [pairs]
          (let [to-kw   (into {} (map #(vector % (keyword (str *ns*) (str %))) (flatten (seq pairs))))
                from-kw (into {} (map #(vector (keyword (str *ns*) (str %)) %) (flatten (seq pairs))))
                hier (reduce (fn [h [p c]] (derive h (to-kw p) (to-kw c))) (make-hierarchy) pairs)
                res  (reduce (fn [s [k v]] (apply conj s (map #(vector (from-kw k) (from-kw %)) v))) #{} (:ancestors hier))]
            res)))

(deftest tests
  (is (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
        (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]})))
  (is (let [more-legs
            #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
        (= (__ more-legs) #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
                            ["spider" "cat"] ["spider" "man"] ["spider" "snake"]})))
  (is (let [progeny
            #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
        (= (__ progeny)
           #{["father" "son"] ["father" "grandson"]
             ["uncle" "cousin"] ["son" "grandson"]}))))
