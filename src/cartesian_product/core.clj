(ns cartesian-product.core
  (:require [clojure.test :refer :all]))

;; Problem 90 - Cartesian Product
;; http://www.4clojure.com/problem/90

(def __ #(into #{} (for [x % y %2] [x y])))

(deftest tests
  (is (= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
         #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
           ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
           ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))

  (is (= (__ #{1 2 3} #{4 5})
         #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))

  (is (= 300 (count (__ (into #{} (range 10))
                        (into #{} (range 30)))))))
