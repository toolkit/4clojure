(ns puzzle-solutions.core)

;; Problem 111 - Crossword Puzzle

(defn make-pattern [word]
  (re-pattern
   (apply str
          (concat "(^|#)"
                  (map #(str "(_|" % ")") word)
                  "(#|$)"))))

(def pat (make-pattern "clojure"))

(map (re-find pat % ) )

(print (re-find pat "_______"))

(defn columns [matrix]
  (partition 1 2 (apply map vector matrix)))

(defn columns [matrix]
  (apply map vector matrix))

(print (columns ["a b c"
                 "d e f"
                 "g h i"]))


(defn letters [line]
  (partition 1 2 line))

(print (letters "a b c d"))

(def m ["_ _ _ # j o y"
        "_ _ o _ _ _ _"
        "_ _ f _ # _ _"])


;; Problem 131 - Sum some set subsets  - TODO

(defn summations [ & sets ]
  (letfn [(powerset [s]
            (reduce (fn [ps x]
                      (reduce (fn [ps s]
                                (conj ps (conj s x))) ps ps)) #{#{}} s))
          (summations [s]
            (set (map (partial apply +) (set (filter #(> (count %) 0) (powerset s))))))]
    (not (empty? (apply clojure.set/intersection (map summations sets))))))

(summations #{-1 1 99} #{-2 4 888})


;; Problem 96 - Beauty is symmetry

(defn t [[n l r]]
  (let [m (fn m [[n l r]]
            (vector n (if (coll? r) (m r) r) (if (coll? l) (m l) l)))]
    (= l (m r))))


(t [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
    [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])


;; Problem 78 - Trampoline

(letfn [(triple [x] #(sub-two (* 3 x)))
        (sub-two [x] #(stop?(- x 2)))
        (stop? [x] (if (> x 50) x #(triple x)))]
  (#(loop [res (apply % %&)]
      (if (fn? res)
        (recur (res)) res)) triple 2))


;; Problem 84 - Transitive Closure

(defn tc [pairs]
  (let [to-kw   (into {} (map #(vector % (keyword (str *ns*) (str %))) (flatten (seq pairs))))
        from-kw (into {} (map #(vector (keyword (str *ns*) (str %)) %) (flatten (seq pairs))))
        hier (reduce (fn [h [p c]] (derive h (to-kw p) (to-kw c))) (make-hierarchy) pairs)
        res  (reduce (fn [s [k v]] (apply conj s (map #(vector (from-kw k) (from-kw %)) v))) #{} (:ancestors hier))]
  res))

(print (tc #{[8 4] [9 3] [4 2] [27 9]}))


;; Problem 121 - Universal Computation Engine

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


;; Problem 101 - Levenshtein distance
(def lev
  (let [mlev
        (memoize
          (fn [mem s t]
            (let [slen (count s)
                  tlen (count t)
                  cost (if (= (last s) (last t)) 0 1)]
              (cond
                (zero? slen) tlen
                (zero? tlen) slen
                :else (min
                        (+ 1 (mem mem (butlast s) t))
                        (+ 1 (mem mem s (butlast t)))
                        (+ cost (mem mem (butlast s) (butlast t))))))))]
    (partial mlev mlev)))

(time (lev "fo" "ba"))

(time (lev "kitten" "sitting"))

(time (lev "ttttattttctg" "tcaaccctaccat"))

;; Problem 150 - Palindromic Numbers
(defn pals [n]
  (let [to-d (fn [n] (map #(- (int %) 48) (str n)))
        to-n (fn [d] (reduce #(+ (* 10 %) %2) 0 d))
        half (fn [d] (take (/ (count d) 2) d))
        reflect (fn [h d] (concat h (reverse (if (even? (count d)) h (butlast h)))))
        next-p (fn [p]
                 (let [d (to-d p)
                       h (-> d half to-n inc to-d)]
                   (if (apply = 9 d)
                     (+ p 2)
                     (to-n (reflect h d)))))
        make-p (fn [n] (-> n to-d half to-n dec to-d (reflect (to-d n)) to-n))
        first-p (fn [n] (if (zero? n) 0
                          (first (drop-while #(< % n) (iterate next-p (make-p n))))))]
    (iterate next-p (first-p n))))

(take 26 (pals 1234550000))
(take 26 (pals 0))
(take 16 (pals 162))


;; Problem 125 - Quines - TODO
(str '(fn [] 2))
((fn [] 2))

(str '(fn [] "(fn []"))
((fn [] "(fn []"))

;;  Problem 171 - Intervals
((fn [a]
  (let [a (sort (set a))
        mi (map-indexed #(vector % %2) a)
        vs (vals (group-by #(apply - %) mi))
        is (map #(vector (last (first %)) (last (last %))) vs)]
  is)) [4 3 2 1 7 8 9])


;; Eulers Totient
((fn [x]
   (if (= 1 x) 1
     (letfn [(gcd [a b] (last (filter #(and (zero? (mod a %)) (zero? (mod b %))) (range 1 (max a b)))))
             (coprime? [a b] (= 1 (gcd a b)))]
       (count (filter (partial coprime? x) (range 1 x)))))) 10)


;; Problem 177 - Balancing Brackets
(#(let [a (clojure.string/replace % #"[^\(^\)^\[^\]^\{^\}]" "")
        b (clojure.string/replace a #"(\(\)|\[\]|\{\})" "")]
    (if (empty? b)
      true
      (if (= b %)
        false
        (recur b)))) "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")


;; Problem 114 - Global take while
(defn gtw [n p s]
   (take
     (last
       (take n (keep-indexed #(if (p %2) %) s)))
     s))

(gtw 4 #(= 2 (mod % 3))
  [2 3 5 7 11 13 17 19 23])

(gtw 3 #(some #{\i} %)
  ["this" "is" "a" "sentence" "i" "wrote"])

;; Problem 178 - Best Hand **
(defn best-hand [cards]
  (let [flush? (apply = (map first cards))
        ranks (map (zipmap "23456789TJQKA" (range 13)) (map last cards))
        freqs (frequencies (vals (frequencies ranks)))
        run? #(= (range (first %) (inc (last %))) %)
        straight? (or (run? (sort ranks)) (run? (sort (replace {12 -1} ranks))))]
    (cond
      (and straight? flush?)  :straight-flush
      (= {4 1 1 1} freqs)     :four-of-a-kind
      (= {3 1 2 1} freqs)     :full-house
      flush?                  :flush
      straight?               :straight
      (= {3 1 1 2} freqs)     :three-of-a-kind
      (= {2 2 1 1} freqs)     :two-pair
      (= {2 1 1 3} freqs)     :pair
      :else                   :high-card)))

(map best-hand
  [["HA" "D2" "H3" "C9" "DJ"]
   ["HA" "DA" "HQ" "SJ" "HT"]
   ["HA" "DA" "HQ" "SQ" "HT"]
   ["HA" "DA" "CA" "HJ" "HT"]
   ["HA" "DK" "HQ" "HJ" "HT"]
   ["HA" "HK" "H2" "H4" "HT"]
   ["HA" "DA" "CA" "HJ" "DJ"]
   ["HA" "DA" "CA" "SA" "DJ"]
   ["HA" "H2" "H3" "H4" "H5"]
   ["HA" "HK" "HQ" "HJ" "HT"]])


;; Problem 73 - Tic Tac Toe
(defn ttt [b]
  (letfn [(win [k]
            (some #(every? #{k} %)
              (concat b                                                    ; original board
                (apply map vector b)                                       ; transposed
                (vector (map #(nth %1 %2) b (range 3)))                    ; 1st diagonal
                (vector (map #(nth %1 %2) b (reverse (range 3)))))))]      ; 2nd diagonal
    (cond
      (win :x) :x
      (win :o) :o)))

(ttt [[:e :e :e]
      [:e :e :e]
      [:e :e :e]])

(ttt [[:x :e :o]
      [:x :e :e]
      [:x :e :o]])

(ttt [[:e :x :e]
      [:o :o :o]
      [:x :e :x]])

(ttt [[:x :e :e]
      [:o :x :o]
      [:x :e :x]])

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
