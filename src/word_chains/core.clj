(ns word-chains.core
  (:require [clojure.test :refer :all]))

;; Problem 82 - Word Chains
;; http://www.4clojure.com/problem/82
;;
;; Not a word chain:
;;    to -- top -- stop
;;           |
;;          tops -- toss
;;
;; Is a word chain:
;;    share -- shares -- hares -- hare -- are
;;      |                           |
;;       ----------------------------

(def __ (fn [s]
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
                exists (fn exists
                         ([s] (not (nil? (some #(exists s %) s))))
                         ([s v]
                          (println s v)
                          (cond
                            (nil? v) false
                            (= s #{v}) true
                            :else (some #(exists (disj s v) %) (filter #(= 1 (lev v %)) s)))))]
            (exists s))))

(deftest tests
  (is (true? (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})))
  (is (false? (__ #{"cot" "hot" "bat" "fat"})))
  (is (false? (__ #{"to" "top" "stop" "tops" "toss"})))
  (is (true? (__ #{"spout" "do" "pot" "pout" "spot" "dot"})))
  (is (true? (__ #{"share" "hares" "shares" "hare" "are"})))
  (is (false? (__ #{"share" "hares" "hare" "are"}))))