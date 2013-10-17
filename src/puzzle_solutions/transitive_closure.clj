(ns puzzle-solutions.transitive-closure)

;; Problem 84 - Transitive Closure
;; http://www.4clojure.com/problem/84

(defn tc [pairs]
  (let [to-kw   (into {} (map #(vector % (keyword (str *ns*) (str %))) (flatten (seq pairs))))
        from-kw (into {} (map #(vector (keyword (str *ns*) (str %)) %) (flatten (seq pairs))))
        hier (reduce (fn [h [p c]] (derive h (to-kw p) (to-kw c))) (make-hierarchy) pairs)
        res  (reduce (fn [s [k v]] (apply conj s (map #(vector (from-kw k) (from-kw %)) v))) #{} (:ancestors hier))]
  res))

(print (tc #{[8 4] [9 3] [4 2] [27 9]}))
