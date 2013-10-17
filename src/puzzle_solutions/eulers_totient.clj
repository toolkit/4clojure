(ns puzzle-solutions.eulers-totient)

;; Problem 75 - Eulers Totient
;; http://www.4clojure.com/problem/75

((fn [x]
   (if (= 1 x) 1
     (letfn [(gcd [a b] (last (filter #(and (zero? (mod a %)) (zero? (mod b %))) (range 1 (max a b)))))
             (coprime? [a b] (= 1 (gcd a b)))]
       (count (filter (partial coprime? x) (range 1 x)))))) 10)
