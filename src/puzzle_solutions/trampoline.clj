(ns puzzle-solutions.trampoline)

;; Problem 78 - Trampoline
;; http://www.4clojure.com/problem/78

(letfn [(triple [x] #(sub-two (* 3 x)))
        (sub-two [x] #(stop?(- x 2)))
        (stop? [x] (if (> x 50) x #(triple x)))]
  (#(loop [res (apply % %&)]
      (if (fn? res)
        (recur (res)) res)) triple 2))
