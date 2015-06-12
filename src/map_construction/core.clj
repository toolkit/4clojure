(ns map-construction.core
  (:require [clojure.test :refer :all]))

;; Problem 61 - Map Construction
;; http://www.4clojure.com/problem/61

(def __ #(into {} (map vector % %2)))

(deftest tests
  (is (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
  (is (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
  (is (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})))
