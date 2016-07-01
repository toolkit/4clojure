(ns latin-square-slicing.core
  (:require [clojure.test :refer :all]))

;; Problem 152 - Lating Square Slicing
;; http://www.4clojure.com/problem/152

(defn is-latin [matrix]
  (let [transpose (partial apply map vector)
        uniqs (partial (comp vals frequencies))]
    (when (and
            (every? #(= 1 %) (mapcat uniqs matrix))
            (every? #(= 1 %) (mapcat uniqs (transpose matrix)))
            (apply = (map sort matrix)))
      matrix)))

(is-latin [[1 2] [2 1]])

(distinct [1 2 2])

(def mat [[1 2 3] [2 3 1] [3 1 2]])

(def a (partition 2 1 mat))

(map (fn [parts] (map (fn [part] (partition 2 1 part)) parts)) a)

(def t [[1 2 9] [2 1 9]])
(map (fn [bit] (partition 2 1 bit)) t)
(def transpose (partial apply map vector))


(defn small-squares [size parts]
  (transpose (map #(partition size 1 %) parts)))

(mapcat #(small-squares 2 %) a)


(defn squares-for [matrix size]
  (let [transpose (partial apply map vector)
        parts (partial partition size 1)
        small-squares (fn [part]
                        (transpose (map #(parts %) part)))]
    (mapcat small-squares (parts matrix))))

(squares-for mat 2)

(keep is-latin (squares-for mat 2))

(map #(keep is-latin (squares-for mat %)) (range 2 (inc (count mat))))

(def __ (fn []))

(deftest tests
  (is (= (__ '[[A B C D]
               [A C D B]
               [B A D C]
               [D C A B]])
         {}))
  (is (= (__ '[[A B C D]
               [A C D B]
               [B A D C]
               [D C A B]])
         {}))
  (is (= (__ '[[A B C D]
               [B A D C]
               [D C B A]
               [C D A B]])
         {4 1, 2 4}))
  (is (= (__ '[[B D A C B]
               [D A B C A]
               [A B C A B]
               [B C A B C]
               [A D B C A]])
         {3 3}))
  (is (= (__ [[2 4 6 3]
              [3 4 6 2]
              [6 2 4]])
         {}))
  (is (= (__ [[1]
              [1 2 1 2]
              [2 1 2 1]
              [1 2 1 2]
              []])
         {2 2}))
  (is (= (__ [[3 1 2]
              [1 2 3 1 3 4]
              [2 3 1 3]])
         {3 1, 2 2}))
  (is (= (__ [[8 6 7 3 2 5 1 4]
              [6 8 3 7]
              [7 3 8 6]
              [3 7 6 8 1 4 5 2]
              [1 8 5 2 4]
              [8 1 2 4 5]])
         {4 1, 3 1, 2 7})))