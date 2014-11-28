(ns best-hand
  (:require [clojure.test :refer [is]]))

;; Problem 178 - Best Hand **
;; http://www.4clojure.com/problem/178

(def __ (fn [cards]
  (let [flush? (apply = (map first cards))
        ranks (map (zipmap "23456789TJQKA" (range 2 15)) (map last cards))
        freqs (frequencies (vals (frequencies ranks)))
        run? #(= (range (first %) (inc (last %))) %)
        straight? (or (run? (sort ranks)) (run? (sort (replace {14 1} ranks))))]
    (cond
      (and straight? flush?)  :straight-flush
      (= {4 1 1 1} freqs)     :four-of-a-kind
      (= {3 1 2 1} freqs)     :full-house
      flush?                  :flush
      straight?               :straight
      (= {3 1 1 2} freqs)     :three-of-a-kind
      (= {2 2 1 1} freqs)     :two-pair
      (= {2 1 1 3} freqs)     :pair
      :else                   :high-card))))

(is (= :high-card (__ ["HA" "D2" "H3" "C9" "DJ"])))
(is (= :pair (__ ["HA" "HQ" "SJ" "DA" "HT"])))
(is (= :two-pair (__ ["HA" "DA" "HQ" "SQ" "HT"])))
(is (= :three-of-a-kind (__ ["HA" "DA" "CA" "HJ" "HT"])))
(is (= :straight (__ ["HA" "DK" "HQ" "HJ" "HT"])))
(is (= :straight (__ ["HA" "H2" "S3" "D4" "C5"])))
(is (= :flush (__ ["HA" "HK" "H2" "H4" "HT"])))
(is (= :full-house (__ ["HA" "DA" "CA" "HJ" "DJ"])))
(is (= :four-of-a-kind (__ ["HA" "DA" "CA" "SA" "DJ"])))
(is (= :straight-flush (__ ["HA" "HK" "HQ" "HJ" "HT"])))