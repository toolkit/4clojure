(ns squares-squared.core
  (:require [clojure.test :refer :all]))

;; TO DO - Still to solve

;; Problem 138 - Squares Squared
;; http://www.4clojure.com/problem/138

;; Create a function of two integer arguments: the start and end, respectively.
;; You must create a vector of strings which renders a 45° rotated square of integers
;; which are successive squares from the start point up to and including the end point.
;; If a number comprises multiple digits, wrap them around the shape individually.
;; If there are not enough digits to complete the shape, fill in the rest with asterisk
;; characters. The direction of the drawing should be clockwise, starting from the center
;; of the shape and working outwards, with the initial direction being down and to the right.

;; Origin Offsets:
;;                  0123    ----> y
;;           -2 "   0   "
;;      |    -1 "  1 0  "
;;      |     0 " 0 1 0 "
;;      |     1 "* 0 0 0"
;;     \|/    2 " * 1 * "
;;      x     3 "  * *  "
;;            4 "   *   "

;; Normalized:
;;               0123456    ----> y
;;            0 "   0   "
;;      |     1 "  1 0  "
;;      |     2 " 0 1 0 "
;;      |     3 "* 0 0 0"
;;     \|/    4 " * 1 * "
;;      x     5 "  * *  "
;;            6 "   *   "

;;
;; As one enourmous function
;;
(def __ (fn [start end]
          (let [squares (fn [s e]
                          (take-while #(<= % e) (iterate #(* % %) s)))
                pad-length (fn [nums]
                             (first (filter #(<= (count (apply str nums)) %) (map #(* % %) (range)))))
                padded (fn [nums length]
                         (take length (apply str (apply str nums) (repeat length "*"))))
                add-points (fn [[x1 y1] [x2 y2]] [(+ x1 x2) (+ y1 y2)])
                sub-points (fn [[x1 y1] [x2 y2]] [(- x1 x2) (- y1 y2)])
                directions (cycle [[1 1] [1 -1] [-1 -1] [-1 1]])
                origin-offsets (fn [n]
                                 (loop [steps (dec n)
                                        accum [[0 0]]
                                        current-dir nil
                                        next-dirs directions]
                                   (if (zero? steps)
                                     accum
                                     (let [test-offset (add-points (last accum) (first next-dirs))]
                                       (if (some #{test-offset} accum)
                                         (recur (dec steps) (conj accum (add-points (last accum) current-dir)) current-dir next-dirs)
                                         (recur (dec steps) (conj accum test-offset) (first next-dirs) (drop 1 next-dirs)))))))
                normalize (fn [offsets]
                            (let [min-x (apply min (map first offsets))
                                  min-y (apply min (map second offsets))]
                              (map #(sub-points % [min-x min-y]) offsets)))
                grid-size (fn [normalized]
                            (inc (apply max (map first normalized))))
                empty-grid (fn [size]
                             (vec (repeat size (vec (repeat size " ")))))
                normalized-with-vals (fn [normalized vals]
                                       (zipmap normalized vals))
                update-grid (fn [grid nv]
                              (reduce #(assoc-in % (first %2) (second %2)) grid nv))
                str-grid (fn [grid]
                           (map #(apply str %) grid))


                sqs (squares start end)
                len (pad-length sqs)
                pad (padded sqs len)
                off (origin-offsets len)
                nrm (normalize off)
                gsz (grid-size nrm)
                grid (empty-grid gsz)
                nv (normalized-with-vals nrm pad)
                grid (update-grid grid nv)
                grid (str-grid grid)]
            grid)))

(deftest tests
  (is (= (__ 2 2) ["2"]))
  (is (= (__ 2 4) [" 2 "
                   "* 4"
                   " * "]))
  (is (= (__ 3 81) [" 3 "
                    "1 9"
                    " 8 "]))
  (is (= (__ 4 20) [" 4 "
                    "* 1"
                    " 6 "]))
  (is (= (__ 2 256) ["  6  "
                     " 5 * "
                     "2 2 *"
                     " 6 4 "
                     "  1  "]))
  (is (= (__ 10 10000) ["   0   "
                        "  1 0  "
                        " 0 1 0 "
                        "* 0 0 0"
                        " * 1 * "
                        "  * *  "
                        "   *   "])))