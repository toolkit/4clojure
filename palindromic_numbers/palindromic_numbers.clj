(ns palindromic-numbers
  (:require [clojure.test :refer [is]]))

;; Problem 150 - Palindromic Numbers
;; http://www.4clojure.com/problem/150

(def __ (fn [n]
          (let [to-d (fn [n] (map #(- (int %) 48) (str n)))
                to-n (fn [d] (reduce #(+ (* 10 %) %2) 0 d))
                half (fn [d] (take (/ (count d) 2) d))
                reflect (fn [h d] (concat h (reverse (if (even? (count d)) h (butlast h)))))
                next-p (fn [f n]
                         (let [d (to-d n)
                               h (-> d half to-n f to-d)]
                           (if (and (apply = 9 d) (= f inc))
                             (+ n 2)    ; bug here for down-p?
                             (to-n (reflect h d)))))
                up-p (partial next-p inc)
                down-p (partial next-p dec)
                first-p (fn [n] (if (zero? n) 0
                                   (first (drop-while #(< % n) (iterate up-p (down-p n))))))]
            (iterate up-p (first-p n)))))

(is (= (take 26 (__ 0))
   [0 1 2 3 4 5 6 7 8 9
    11 22 33 44 55 66 77 88 99
    101 111 121 131 141 151 161]))

(is (= (take 16 (__ 162))
   [171 181 191 202
    212 222 232 242
    252 262 272 282
    292 303 313 323]))

(is (= (take 6 (__ 1234550000))
   [1234554321 1234664321 1234774321
    1234884321 1234994321 1235005321]))

(is (= (first (__ (* 111111111 111111111)))
       (* 111111111 111111111)))

(is (= (set (take 199 (__ 0)))
   (set (map #(first (__ %)) (range 0 10000)))))

(is (= true
       (apply < (take 6666 (__ 9999999)))))

(is (= (nth (__ 0) 10101)
       9102019))
