(ns puzzle-solutions.best-hand)

;; Problem 178 - Best Hand **
;; http://www.4clojure.com/problem/178

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
