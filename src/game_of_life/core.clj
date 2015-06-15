(ns game-of-life.core
  (:require [clojure.test :refer :all]))

;; Problem 94 - Game of Life
;; https://www.4clojure.com/problem/94

(def __ (fn [game]
          (let [adjacent (fn [[x y]]
                           (filter #(not (some #{-1} %))
                                   [[(dec x) (dec y)]
                                    [(dec x) y]
                                    [(dec x) (inc y)]
                                    [x (dec y)]
                                    [x (inc y)]
                                    [(inc x) (dec y)]
                                    [(inc x) y]
                                    [(inc x) (inc y)]]))
                step-cell (fn [cell game]
                            (let [live? (fn [value] (= \# value))
                                  value (get-in game cell)
                                  neighbours (adjacent cell)
                                  live-neighbours (count (filter live? (map #(get-in game %) neighbours)))
                                  live-map (zipmap (range 0 9) "  ##     ")
                                  dead-map (zipmap (range 0 9) "   #     ")]
                              (if (live? value)
                                (live-map live-neighbours)
                                (dead-map live-neighbours))))
                step (fn [game]
                       (let [size (count game)]
                         (map #(apply str %)
                              (partition size (for [x (range 0 size)
                                                    y (range 0 size)
                                                    :let [cell [x y]]]
                                                (step-cell cell game))))))]
            (step game))))


(deftest tests
  (is (= (__ ["      "
              " ##   "
              " ##   "
              "   ## "
              "   ## "
              "      "])
         ["      "
          " ##   "
          " #    "
          "    # "
          "   ## "
          "      "]))
  (is (= (__ ["     "
              "     "
              " ### "
              "     "
              "     "])
         ["     "
          "  #  "
          "  #  "
          "  #  "
          "     "]))
  (is (= (__ ["      "
              "      "
              "  ### "
              " ###  "
              "      "
              "      "])
         ["      "
          "   #  "
          " #  # "
          " #  # "
          "  #   "
          "      "])))