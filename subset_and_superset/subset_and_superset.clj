(ns subset-and-superset
  (:require [clojure.test :refer [is]]))

;; Problem 161 - Subset and Superset
;; http://www.4clojure.com/problem/161

(def __ #{1 2})

(is (clojure.set/superset? __ #{2}))
(is (clojure.set/subset? #[1] __))
(is (clojure.set/superset? __ #{1 2}))
(is (clojure.set/subset? #{1 2} __))
