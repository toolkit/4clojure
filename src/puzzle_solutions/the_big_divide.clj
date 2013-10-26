(ns puzzle-solutions.the-big-divide
  (:require [clojure.test :refer [is]]))

;; Problem 148 - The big divide
;; http://www.4clojure.com/problem/148

(def __ (fn [lim a b]
          (letfn [(summ [x]
                    (let [n (quot (dec lim) x)]
                      (*' (/ (*' n (inc n)) 2) x)))]
            (- (+' (summ a) (summ b)) (summ (*' a b))))))

(is (= 0 (__ 3 17 11)))
(is (= 23 (__ 10 3 5)))
(is (= 233168 (__ 1000 3 5)))
(is (= "2333333316666668" (str (__ 100000000 3 5))))
(is (= "110389610389889610389610"
       (str (__ (* 10000 10000 10000) 7 11))))
(is (= "1277732511922987429116"
       (str (__ (* 10000 10000 10000) 757 809))))
(is (= "4530161696788274281"
       (str (__ (* 10000 10000 1000) 1597 3571))))
