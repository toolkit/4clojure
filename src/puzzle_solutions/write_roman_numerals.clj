(ns puzzle-solutions.write-roman-numerals)

;; Problem 104 - Write Roman Numerals
;; http://www.4clojure.com/problem/104

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
