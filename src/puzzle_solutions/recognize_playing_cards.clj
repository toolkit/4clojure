(ns puzzle-solutions.reconize-playing-cards
  (:require [clojure.test :refer [is]]))

;; Problem 128 - Recognize Playing Cards
;; http://www.4clojure.com/problem/128

(def __ (fn [[s r]]
          {:suit ({\H :heart \D :diamond \C :club \S :spade} s)
           :rank ((zipmap "23456789TJQKA" (range 13)) r)}))

(is (= {:suit :diamond :rank 10} (__ "DQ")))
(is (= {:suit :heart :rank 3} (__ "H5")))
(is (= {:suit :club :rank 12} (__ "CA")))
(is (= (range 13) (map (comp :rank __ str)
                       '[S2 S3 S4 S5 S6 S7
                         S8 S9 ST SJ SQ SK SA])))