(ns word-chains.core)

;; STILL UNDER DEVELOPMENT

;; Problem 82 - Word Chains
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

(defn combinations [k s]
  (letfn [(powerset [s]
            (reduce (fn [ps x]
                      (reduce (fn [ps s]
                                (conj ps (conj s x))) ps ps)) #{#{}} s))]
        (set (filter #(= k (count %)) (powerset s)))))

(map
 #(vector % (apply lev %))
 (combinations 2 #{"share" "hares" "shares" "hare" "are"}))
