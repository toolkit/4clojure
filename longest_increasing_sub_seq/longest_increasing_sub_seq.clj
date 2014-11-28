(ns longest-increasing-sub-seq
  (:require [clojure.test :refer [is]]))

;; Problem 53 - Longest Inscreasing Sub-seq
;; http://www.4clojure.com/problem/53

(def __ (fn [c]
          (let [increasing (fn [p] (every? true? (map = p (iterate inc (first p)))))
                candidates (for [x (-> c count inc (range 1 -1))
                                 :let [y (partition x 1 c)
                                       z (filter increasing y)]
                                 :when (not-empty z)] z)]
            (if-let [longest (ffirst candidates)]
              longest
              []))))

(is (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3]))
(is (= (__ [5 6 1 3 2 7]) [5 6]))
(is (= (__ [2 3 3 4 5]) [3 4 5]))
(is (= (__ [7 6 5 4]) []))
