(ns puzzle-solutions.to-tree-or-not-to-tree
  (:require [clojure.test :refer [is]]))

;; Problem 95 - To Tree, or not to Tree
;; http://www.4clojure.com/problem/95

(def __ (fn tree [[_ l r :as a]]
          (and
           (= 3 (count a))
           (if (sequential? l)
             (tree l)
             (nil? l))
           (if (sequential? r)
             (tree r)
             (nil? r)))))

(is (= (__ '(:a (:b nil nil) nil))
       true))
(is (= (__ '(:a (:b nil nil)))
       false))
(is (= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
       true))
(is (= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
       false))
(is (= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
       true))
(is (= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
       false))
(is (= (__ '(:a nil ()))
       false))
