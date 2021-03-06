(ns beauty-is-symmetry.core
  (:require [clojure.test :refer :all]))

;; Problem 96 - Beauty is symmetry
;; http://www.4clojure.com/problem/96

(def __ (fn [[_ l r]]
  (let [m (fn m [[n l r]]
            (vector n (if (coll? r) (m r) r) (if (coll? l) (m l) l)))]
    (= l (m r)))))

(deftest tests
  (is (= (__ '(:a (:b nil nil) (:b nil nil))) true))
  (is (= (__ '(:a (:b nil nil) nil)) false))
  (is (= (__ '(:a (:b nil nil) (:c nil nil))) false))
  (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
              [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
         true))
  (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
              [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
         false))
  (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
              [2 [3 nil [4 [6 nil nil] nil]] nil]])
         false)))
