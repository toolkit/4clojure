(ns making-data-dance
  (:require [clojure.test :refer :all]))

;; Problem 113 - Making Data Dance
;; http://www.4clojure.com/problem/113

(def __ #(reify clojure.lang.Seqable
           (toString [_] (clojure.string/join ", " (sort %&)))
           (seq [_] (seq (distinct %&)))))

(is (= "1, 2, 3" (str (__ 2 1 3))))
(is (= '(2 1 3) (seq (__ 2 1 3))))
(is (= '(2 1 3) (seq (__ 2 1 3 3 1 2))))
(is (= '(1) (seq (apply __ (repeat 5 1)))))
(is (= "1, 1, 1, 1, 1" (str (apply __ (repeat 5 1)))))
(is (and (= nil (seq (__)))
         (=  "" (str (__)))))
