(ns re-implement-map
  (:require [clojure.test :refer :all]))

;; Problem 118 - Re-implement map
;; http://www.4clojure.com/problem/118

(def __
  (fn mmm [f c]
    (when-let [s (seq c)]
      (cons (f (first s)) (lazy-seq (mmm f (rest s)))))))

(deftest tests
  (is (= [3 4 5 6 7]
         (__ inc [2 3 4 5 6])))
  (is (= (repeat 10 nil)
         (__ (fn [_] nil) (range 10))))
  (is (= [1000000 1000001]
         (->> (__ inc (range))
              (drop (dec 1000000))
              (take 2)))))
