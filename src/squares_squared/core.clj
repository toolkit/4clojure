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
;;                  0123    ----> x
;;           -2 "   0   "
;;      |    -1 "  1 0  "
;;      |     0 " 0 1 0 "
;;      |     1 "* 0 0 0"
;;     \|/    2 " * 1 * "
;;      y     3 "  * *  "
;;            4 "   *   "

(def __ (fn [start end]
          (let [nums (take-while #(<= % end) (iterate #(* % %) start))
                pad-length (first (filter #(< (count (apply str nums)) %) (map #(* % %) (range))))
                padded (take pad-length (apply str (apply str nums) (repeat pad-length "*")))]
            padded)))

(__ 2 1024)


;; explained in functions
(defn squares [start end]
  (take-while #(<= % end) (iterate #(* % %) start)))

(defn pad-length [nums]
  (first (filter #(< (count (apply str nums)) %) (map #(* % %) (range)))))

(defn padded [nums length]
  (take length (apply str (apply str nums) (repeat length "*"))))

(defn add-points [[x1 y1] [x2 y2]] [(+ x1 x2) (+ y1 y2)])

(def directions (cycle [[1 1] [-1 1] [-1 -1] [1 -1]]))

(defn origin-offsets [n]
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

(deftest origin-offsets-test
  (is (= [[0 0] [1 1] [0 2] [-1 1] [-2 0] [-1 -1] [0 -2] [1 -1] [2 0]]
         (origin-offsets 9))))

(defn grid-size [offsets]
  (let [max-x (apply max (map first offsets))
        min-x (apply min (map first offsets))
        max-y (apply max (map second offsets))
        min-y (apply min (map second offsets))]
    (max (inc (- max-x min-x))
         (inc (- max-y min-y)))))

(defn empty-grid [size]
  (vec (repeat size (repeat size " "))))

(def g (empty-grid 7))

(defn update-grid [grid offset val]
  (assoc-in grid offset val))

(update-grid g [1 1] "A")


(origin-offsets 16)
(origin-offsets 4)

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