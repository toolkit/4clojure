(ns puzzle-solutions.analyze-a-tic-tac-toe-board
  (:require [clojure.test :refer [is]]))

;; Problem 73 - Analyze a Tic-Tac-Toe Board
;; http://www.4clojure.com/problem/73

(def __ (fn [b]
  (letfn [(win [k]
            (some #(every? #{k} %)
              (concat b                                                    ; original board
                (apply map vector b)                                       ; transposed
                (vector (map #(nth %1 %2) b (range 3)))                    ; 1st diagonal
                (vector (map #(nth %1 %2) b (reverse (range 3)))))))]      ; 2nd diagonal
    (cond
      (win :x) :x
      (win :o) :o))))

(is
 (= nil (__ [[:e :e :e]
             [:e :e :e]
             [:e :e :e]])))

(is
 (= :x (__ [[:x :e :o]
            [:x :e :e]
            [:x :e :o]])))

(is
 (= :o (__ [[:e :x :e]
            [:o :o :o]
            [:x :e :x]])))

(is
 (= nil (__ [[:x :e :o]
             [:x :x :e]
             [:o :x :o]])))

(is
 (= :x (__ [[:x :e :e]
            [:o :x :e]
            [:o :e :x]])))

(is
 (= :o (__ [[:x :e :o]
            [:x :o :e]
            [:o :e :x]])))

(is
 (= nil (__ [[:x :o :x]
             [:x :o :x]
             [:o :x :o]])))
