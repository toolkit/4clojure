(ns puzzle-solutions.core)

;; Problem 138 - Squares Squared
(defn prange [x y]
  (take-while #(<= % y) (iterate #(* % %) x)))

(prange 4 20)

(count (apply str (prange 10 10000)))

(defn required-size [s]
  (first (drop-while #(> (count s) %) (map #(* % %) (range)))))

(required-size "1010010000")

;; Problem 53 - Longest sequence
(defn longest-sequence [c]
  (let [increasing (fn [p] (every? true? (map = p (iterate inc (first p)))))
           candidates (for [x (rseq (vec (range 2 (inc (count c)))))
                        :let [y (partition x 1 c)
                              z (filter increasing y)]
                        :when (not-empty z)] z)]
    (if-let [longest (ffirst candidates)]
      longest
      [])))

(print (longest-sequence [1 2 3 4 6 7 8 9 10 7 8 9 7]))

;; Problem 86 - Happy numbers
(defn happy [x]
  (letfn [(sumsq [y] (reduce + (map #(* % %) (map #(- (int %) 48) (str y)))))]
    (loop [z (sumsq x)
           seen #{}]
      (comment (printf "%d, %s\n" z seen))
      (cond
        (seen z) false
        (= 1 z) true
        :else (recur (sumsq z) (conj seen z))))))

(take 10 (drop 20 (filter happy (range))))

;; Problem 95 - To Tree, or not to Tree
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

;; Problem 65 - Black box testing


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

;; Problem 104 - Write Roman Numerals
(defn write-roman [n]
  (let [vals [1000 900 500 400 100 90 50 40 10 9 5 4 1]
      strs ["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]
      roman (zipmap vals strs)]
  (loop [values vals
         current n
         accum []]
    (if (empty? values)
      (apply str accum)
      (let [v (first values)
            next (- current v)]
        (if (neg? next)
          (recur (rest values) current accum)
          (recur values next (conj accum (roman v)))))))))

(write-roman 2444)

;; Problem 92 - Read Roman Numerals
(fn [n]
  (let [ks ["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]
        vs [1000 900 500 400 100 90 50 40 10 9 5 4 1]
        roman (zipmap ks vs)
        pattern (re-pattern (apply str (interpose "|" ks)))]
    (apply + (map roman (re-seq pattern n)))))

(defn read-roman [s]
  (let [ks ["M" "CM" "D" "CD" "C" "XC" "L" "XL" "X" "IX" "V" "IV" "I"]
        vs [1000 900 500 400 100 90 50 40 10 9 5 4 1]
        roman (zipmap ks vs)
        pattern (re-pattern (apply str (interpose "|" ks)))]
    (apply + (map roman (re-seq pattern s)))))

(read-roman "MCMLXXXIV")
(read-roman "MMXIII")
(read-roman "MCMLXXI")
(read-roman "MCMXLV")

;; Problem 60 - Sequence Reductions
(defn red
  ([f a] (red f (first a) (rest a)))
  ([f i a]
    (cons i
      (lazy-seq
        (when (seq a)
          (red f (f i (first a)) (rest a)))))))

(take 5 (red + (range)))
