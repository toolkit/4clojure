(ns puzzle-solutions.black-box-testing)

;; Problem 65 - Black box testing
;; http://www.4clojure.com/problem/65

(map #(cond
       (reversible? %) :vector
       (associative? %) :map
       (= % (apply list %)) :list
       :else :set) [[] #{} {} ()])

;; Problem 58 - function composition
(((fn [& fs]
    (reduce (fn [f g]
              #(f (apply g %&))) fs))
   #(.toUpperCase %) #(apply str %) take) 5 "hello world")


;; Problem 150 - Palindromic numbers
(defn to-num [v]
  (reduce + (map * (reverse v) (iterate (partial * 10) 1))))

(defn to-seq [n]
  (map #(- (int %) 48) (str n)))

(to-seq 123)
(to-num (to-seq 123))
