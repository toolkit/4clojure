(ns puzzle-solutions.to-tree-or-not-to-tree)

;; Problem 95 - To Tree, or not to Tree
;; http://www.4clojure.com/problem/95

(defn tree [[node left right & extra :as args]]
  (and
    (= 3 (count args))
    (if (sequential? left)
      (tree left)
      (nil? left))
    (if (sequential? right)
      (tree right)
      (nil? right))))

(def t '(:a (:b nil nil)))
(def t [1 [2 [3 [4 nil nil] nil] nil] nil])
(def t [1 [2 [3 [4 false nil] nil] nil] nil])

(tree t)

;; Problem 28 - Flatten
(def a ["a" ["b"] "c"])
(def b '("a" ("b") "c"))

(defn f [c]
  (if (coll? c)
    (mapcat f c)
    [c]))

(f a)
