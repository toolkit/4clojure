(ns analyze-reversi.core
  (:require [clojure.test :refer :all]))

;; Problem 124 - Analyze reversi
;; http://www.4clojure.com/problem/124

;;
;; Reversi is normally played on an 8 by 8 board.
;; In this problem, a 4 by 4 board is represented as a two-dimensional vector with black,
;; white, and empty pieces represented by 'b, 'w, and 'e, respectively.
;;
;; Create a function that accepts a game board and color as arguments, and returns a map
;; of legal moves for that color. Each key should be the coordinates of a legal move,
;; and its value a set of the coordinates of the pieces flipped by that move.
;;
;; Board coordinates should be as in calls to get-in.
;;
;; For example, [0 1] is the topmost row, second column from the left.
;;

(def __
  (fn [board color]
    (into {}
          (let [directions (for [x [-1 0 1] y [-1 0 1] :when (not (= 0 x y))] [x y])
                follow-direction (fn follow-direction [board start direction]
                                   (lazy-seq
                                     (cons start
                                           (follow-direction board (mapv + start direction) direction))))
                flip (fn [board path color]
                       (let [complement (zipmap '[w b] '[b w])
                             first-cell (first path)
                             filter (fn [cell] (= (complement color) (get-in board cell)))
                             flip-cells (take-while filter (rest path))
                             last-cell (first (drop-while filter (rest path)))]
                         (set (when (and (= 'e (get-in board first-cell))
                                         (> (count flip-cells) 0)
                                         (= color (get-in board last-cell)))
                                flip-cells))))]
            (for [x (range 4)
                  y (range 4)
                  direction directions
                  :let [start [x y]
                        path (follow-direction board start direction)
                        flipped (flip board path color)]
                  :when (> (count flipped) 0)]
              [start flipped])))))

(deftest tests
         (is (= (__ '[[e e e e]
                      [e w b e]
                      [e b w e]
                      [e e e e]] 'w)
                {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}))
         (is (= (__ '[[e e e e]
                      [e w b e]
                      [w w w e]
                      [e e e e]] 'b)
                {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}))
         (is (= (__ '[[e e e e]
                      [e w b e]
                      [w w b e]
                      [e e b e]] 'w)
                {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}))
         (is (= (__ '[[e e w e]
                      [b b w e]
                      [b w w e]
                      [b w w w]] 'b)
                {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}})))
