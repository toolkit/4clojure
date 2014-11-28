(ns puzzle-solutions.win-at-tic-tac-toe
  (:require [clojure.test :refer [is]]))

;; Problem 119 - Win at Tic-Tac-Toe
;; http://www.4clojure.com/problem/119

(def __ (fn [side board]
          (let [candidates (fn [board]
                             (for [row (range 3)
                                   col (range 3)
                                   :let [candidate (get-in board [row col])]
                                   :when (= :e candidate)]
                               [row col]))
                check (fn [side board]
                        (some #(every? #{side} %)
                              (concat board
                                      (apply map vector board)
                                      (vector (map #(nth %1 %2) board (range 3)))
                                      (vector (map #(nth %1 %2) board (reverse (range 3)))))))]
            (set (filter #(not (nil? (check side (assoc-in board % side))))
                         (candidates board))))))

(is (= (__ :x [[:o :e :e]
               [:o :x :o]
               [:x :x :e]])
       #{[2 2] [0 1] [0 2]}))
(is (= (__ :x [[:x :o :o]
               [:x :x :e]
               [:e :o :e]])
       #{[2 2] [1 2] [2 0]}))
(is (= (__ :x [[:x :e :x]
               [:o :x :o]
               [:e :o :e]])
       #{[2 2] [0 1] [2 0]}))
(is (= (__ :x [[:x :x :o]
               [:e :e :e]
               [:e :e :e]])
       #{}))
(is (= (__ :o [[:x :x :o]
               [:o :e :o]
               [:x :e :e]])
       #{[2 2] [1 1]}))
