(ns the-balance-of-n
  (:require [clojure.test :refer :all]))

;; Problem 115 - The balance of N
;; http://www.4clojure.com/problem/115

(def __ (fn [x]
          (let [m (zipmap (str "0123456789") (range))
                d (map #(m %) (str x))
                l (/ (count d) 2)]
            (= (apply + (take l d))
               (apply + (take-last l d))))))

(deftest tests
  (is (= true (__ 11)))
  (is (= true (__ 121)))
  (is (= false (__ 123)))
  (is (= true (__ 0)))
  (is (= false (__ 88099)))
  (is (= true (__ 89098)))
  (is (= true (__ 89089)))
  (is (= (take 20 (filter __ (range)))
         [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])))
