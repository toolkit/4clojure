(ns puzzle-solutions.levenshtein-distance)

;; Problem 101 - Levenshtein distance
;; http://www.4clojure.com/problem/101

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
