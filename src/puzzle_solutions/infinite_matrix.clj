(ns puzzle-solutions.infinite-matrix)

;; Problem 168 - Infinite Matrix
;; http://www.4clojure.com/problem/168

(defn inf
  ([f] (inf f 0 0) )
  ([f m n s t] (take s (map #(take t %) (inf f m n))))
  ([f m n]
     (let [row-seq (fn row-seq [i j]
                     (lazy-seq (cons (f i j) (row-seq i (inc j)))))
           rows-seq (fn rows-seq [i j]
                      (lazy-seq (cons (row-seq i j) (rows-seq (inc i) j))))]
       (rows-seq m n))))

(take 5 (map #(take 6 %) (inf str)))
(take 6 (map #(take 5 %) (inf str 3 2)))
(inf * 3 5 5 7)
(class (inf (juxt bit-or bit-xor)))
