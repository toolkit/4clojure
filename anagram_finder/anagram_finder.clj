(ns anagram-finder
  (:require [clojure.test :refer [is]]))

;; Problem 77 - Anagram Finder
;; http://www.4clojure.com/problem/77

(def __ #(set
    (map (comp set val)
      (remove (comp #{1} count val)
        (group-by sort %)))))

(is (= (__ ["meat" "mat" "team" "mate" "eat"])
       #{#{"meat" "team" "mate"}}))

(is (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))
