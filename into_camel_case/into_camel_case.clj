(ns into-camel-case
  (:require [clojure.test :refer [is]]))

;; Problem 171 - Intervals
;; http://www.4clojure.com/problem/171

(def __ (fn [s]
          (clojure.string/replace
           s
           #"-(.)"
           #(clojure.string/upper-case (last %1)))))



(is (= (__ "something") "something"))
(is (= (__ "multi-word-key") "multiWordKey"))
(is (= (__ "leaveMeAlone") "leaveMeAlone"))
