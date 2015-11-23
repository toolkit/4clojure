(ns word-chains.core
  (:use [midje.sweet])
  (:require [clojure.test :refer :all]))

;; Problem 82 - Word Chains
;; http://www.4clojure.com/problem/82

(def __ (fn [_] false))

(defn lev [s t]
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
    (mlev mlev s t)))

(defn pairs [s]
  (into #{} (for [x s y s :when (neg? (compare x y))] [x y])))

(defn just-ones [s]
  (into #{} (filter (fn [[x y]] (= 1 (lev x y))) (pairs s))))

(facts "about levenshtein distance"
       (lev "abc" "ab") => 1
       (lev "abb" "abc") => 1
       (lev "abc" "abcdef") => 3)

(facts "about pairs"
       (pairs #{1 2 3}) => #{[1 2] [1 3] [2 3]}
       (pairs #{"abc" "def" "ghi" "jkl"})
        => #{["abc" "def"] ["abc" "ghi"] ["abc" "jkl"] ["def" "ghi"] ["def" "jkl"] ["ghi" "jkl"]})

(facts "about just-ones"
       (just-ones #{"abc" "ab" "abcd" "zzz" "kkk" "lll"})
        => #{["ab" "abc"] ["abc" "abcd"]}
       (just-ones #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})
        => #{["cat" "hat"] ["hat" "oat"] ["hat" "hot"] ["coat" "oat"]
             ["coat" "cot"] ["cat" "cot"] ["cat" "oat"] ["cat" "coat"]
             ["dog" "hog"] ["cot" "hot"] ["hog" "hot"] })

(deftest tests
  (is (= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})))
  (is (= false (__ #{"cot" "hot" "bat" "fat"})))
  (is (= false (__ #{"to" "top" "stop" "tops" "toss"})))
  (is (= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"})))
  (is (= true (__ #{"share" "hares" "shares" "hare" "are"})))
  (is (= false (__ #{"share" "hares" "hare" "are"}))))

