(ns puzzle-solutions.through-the-looking-glass
  (:require [clojure.test :refer [is]]))

;; Problem 126 - Through the looking glass
;; http://www.4clojure.com/problem/126

(def __ Class)

(let [x __]
      (and (= class x) x) x))
