(ns puzzle-solutions.universal-computation-engine)

;; Problem 121 - Universal Computation Engine
;; http://www.4clojure.com/problem/121

(((fn [tree]
     (fn [m]
       (let [m (merge m {'/ / '* * '+ + '- -})]
         (clojure.walk/postwalk
           (fn [node]
             (cond
               (contains? m node) (node m)
               (list? node) (apply (first node) (rest node))
               :else node)) tree)))) '(/ a b))
  '{b 8 a 16})
