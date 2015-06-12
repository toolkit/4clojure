(ns levenshtein-distance.core
  (:require [clojure.test :refer :all]))

;; Problem 101 - Levenshtein distance
;; http://www.4clojure.com/problem/101

(def __ (let [mlev
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

(deftest tests
  (is (= (__ "kitten" "sitting") 3))
  (is (= (__ "closure" "clojure") (__ "clojure" "closure") 1))
  (is (= (__ "xyx" "xyyyx") 2))
  (is (= (__ "" "123456") 6))
  (is (= (__ "Clojure" "Clojure") (__ "" "") (__ [] []) 0))
  (is (= (__ [1 2 3 4] [0 2 3 4 5]) 2))
  (is (= (__ '(:a :b :c :d) '(:a :d)) 2))
  (is (= (__ "ttttattttctg" "tcaaccctaccat") 10))
  (is (= (__ "gaattctaatctc" "caaacaaaaaattt") 9)))
