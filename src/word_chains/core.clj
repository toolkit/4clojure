(ns word-chains.core
  (:use [midje.sweet]))

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
  (into #{} (map (partial apply hash-set)
                 (filter (fn [[x y]] (= 1 (lev x y))) (pairs s)))))

(defn nodes-possibly-connected [s]
  (into #{} (mapcat identity (just-ones s))))

(facts "about levenshtein distance"
       (lev "abc" "ab")     => 1
       (lev "abb" "abc")    => 1
       (lev "abc" "abcdef") => 3)

(facts "about pairs"
       (pairs #{1 2 3})                   => #{[1 2] [1 3] [2 3]}
       (pairs #{"abc" "def" "ghi" "jkl"}) => #{["abc" "def"] ["abc" "ghi"] ["abc" "jkl"]
                                               ["def" "ghi"] ["def" "jkl"] ["ghi" "jkl"]})

(facts "about just-ones"
       (just-ones #{"abc" "ab" "abcd" "zzz" "kkk" "lll"}) => #{#{"ab" "abc"} #{"abc" "abcd"}})

(facts "about nodes possibly connected"
       (nodes-possibly-connected #{"aa" "ab" "ac" "zz"}) => #{"aa" "ab" "ac"})

(facts "about word chains"
       (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}) => true
       (__ #{"cot" "hot" "bat" "fat"})                          => false
       (__ #{"to" "top" "stop" "tops" "toss"})                  => false
       (__ #{"spout" "do" "pot" "pout" "spot" "dot"})           => true
       (__ #{"share" "hares" "shares" "hare" "are"})            => true
       (__ #{"share" "hares" "hare" "are"})                     => false)