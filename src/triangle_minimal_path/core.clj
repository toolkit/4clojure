(ns triangle-minimal-path.core
  (:require [clojure.test :refer :all]))

;; Problem 79 - Triangle Minimal Path
;; http://www.4clojure.com/problem/79

(def __
  (fn [tri]
    (letfn [(paths
              ([n] (paths n 0))
              ([n idx]
                 (if (= n 1)
                   [[idx]]
                   (map #(cons idx %)
                        (concat
                         (paths (dec n) idx)
                         (paths (dec n) (inc idx)))))))]
      (first
       (sort
        (map
         (fn [path]
           (reduce +
                   (map
                    (fn [row idx]
                      (get row idx))
                    tri path)))
         (paths (count tri))))))))

(deftest tests
  (is (= 7 (__ '([1]
                   [2 4]
                     [5 1 4]
                       [2 3 4 5]))))

  (is (= 20 (__ '([3]
                    [2 4]
                      [1 9 3]
                        [9 9 2 4]
                          [4 6 6 7 8]
                            [5 7 3 5 1 4])))))
