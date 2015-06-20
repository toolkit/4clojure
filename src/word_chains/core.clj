(ns word-chains.core
  (:require [clojure.test :refer :all]))

;; Problem 82 - Word Chains
;; http://www.4clojure.com/problem/82

(def __ (fn word-chain [words]
          (let [mlev (memoize
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
                                     (+ cost (mem mem (butlast s) (butlast t))))))))
                lev (partial mlev mlev)
                combinations (fn [k s]
                               (letfn [(powerset [s]
                                                 (reduce (fn [ps x]
                                                           (reduce (fn [ps s]
                                                                     (conj ps (conj s x))) ps ps)) #{#{}} s))]
                                 (set (filter #(= k (count %)) (powerset s)))))
                one-different (fn [words]
                                (filter (fn [word-pair]
                                          (= 1 (apply lev word-pair)))
                                        (combinations 2 words)))
                connected? (fn [words]
                             (let [edges (one-different words)
                                   sets (set (map set edges))
                                   nodes (set (mapcat identity sets))
                                   grow (fn [nodes]
                                          (set (mapcat identity (for [n nodes s sets :when (contains? s n)] s))))
                                   connected (loop [prev #{(first nodes)} next (grow prev)]
                                               (if (= prev next) prev (recur next (grow next))))]
                               (= words connected)))]
            (connected? words))))

; Need to solve the graph tour before this works properly
; Connected just confirms all nodes are connected, not that
; they form a walk.

(deftest tests
  (is (= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})))
  (is (= false (__ #{"cot" "hot" "bat" "fat"})))
  (is (= false (__ #{"to" "top" "stop" "tops" "toss"})))
  (is (= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"})))
  (is (= true (__ #{"share" "hares" "shares" "hare" "are"})))
  (is (= false (__ #{"share" "hares" "hare" "are"}))))

