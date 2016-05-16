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
                             first-color (get-in board (first path))
                             result (and (= 'e first-color)
                                         (take-while (fn [cell]
                                                       (= (complement color) (get-in board cell))) (rest path)))]
                         (when result
                           (set result))))]
            (for [x (range 4)
                  y (range 4)
                  direction directions
                  :let [start [x y]
                        path (follow-direction board start direction)
                        flipped (flip board path color)]
                  :when (> (count flipped) 0)]
              [start flipped])))))

(def directions (for [x [-1 0 1] y [-1 0 1] :when (not (= 0 x y))] [x y]))

(defn follow-direction [board start direction]
  (lazy-seq
    (cons start (follow-direction board (mapv + start direction) direction))))

(defn colours [board start direction]
  (map (partial get-in board) (follow-direction board start direction)))

(defn how-many? [colour colours]
  (let [complement (zipmap '[w b] '[b w])]
    (and (= 'e (first colours))
      (take-while (fn [c]
                    (= (complement colour) c)) (rest colours)))))

(defn flipped [board path color]
  (let [complement (zipmap '[w b] '[b w])
        first-cell (first path)
        filter (fn [cell]
                 (= (complement color) (get-in board cell)))
        flip-cells (take-while filter (rest path))
        last-cell (drop-while filter (rest path))]
    (first path)
    (comment (and (= 'e (get-in board first-cell))
                  (> (count flip-cells) 0)
                  (= color (get-in board last-cell))))))

(let [b '[[e e e e]
          [e w b e]
          [e b w e]
          [e e e b]]]
  (flipped b (follow-direction b [0 0] [1 1]) 'b))

(take 10 (follow-direction '[[e e e e]
                             [e w b e]
                             [e b w e]
                             [e e e b]] [0 0] [1 1]))

(__ '[[e e e e]
      [e w b e]
      [w w b e]
      [e e b e]] 'w)

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
