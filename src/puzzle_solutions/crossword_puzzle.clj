(ns puzzle-solutions.crossword-puzzle)

;; TODO - Not yet solved.

;; Problem 111 - Crossword Puzzle
;; http://www.4clojure.com/problem/111

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
