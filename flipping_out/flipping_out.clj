(ns flipping-out
  (:require [clojure.test :refer [is]]))

;; Problem 46 - Flipping Out
;; http://www.4clojure.com/problem/46

(def __ #(fn [& args]
           (apply % (reverse args))))

(is (= 3 ((__ nth) 2 [1 2 3 4 5])))
(is (= true ((__ >) 7 8)))
(is (= 4 ((__ quot) 2 8)))
(is (= [1 2 3] ((__ take) [1 2 3 4 5] 3)))
