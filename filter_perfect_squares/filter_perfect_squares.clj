(ns filter-perfect-squares
  (:require [clojure.test :refer :all]))

;; Problem 74 - Filter Perfect Squares
;; http://www.4clojure.com/problem/74

(def __ (fn [s]
          (apply str
                 (interpose ","
                            (filter #(let [l (int (Math/sqrt %))]
                                       (= % (* l l)))
                                    (map #(read-string %) (.split s ",")))))))

(deftest tests
  (is (= (__ "4,5,6,7,8,9") "4,9"))
  (is (= (__ "15,16,25,36,37") "16,25,36")))
