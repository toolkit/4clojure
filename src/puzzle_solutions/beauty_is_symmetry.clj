(ns puzzle-solutions.beauty-is-symmetry)

;; Problem 96 - Beauty is symmetry
;; http://www.4clojure.com/problem/96

(defn t [[n l r]]
  (let [m (fn m [[n l r]]
            (vector n (if (coll? r) (m r) r) (if (coll? l) (m l) l)))]
    (= l (m r))))


(t [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
    [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
