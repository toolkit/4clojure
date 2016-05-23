(ns into-camel-case.core
  (:require [clojure.test :refer :all]))

;; Problem 102 - intoCamelCase
;; http://www.4clojure.com/problem/102

(def __ #(clojure.string/replace % #"-(.)" (comp clojure.string/upper-case last)))

(deftest tests
  (is (= (__ "something") "something"))
  (is (= (__ "multi-word-key") "multiWordKey"))
  (is (= (__ "leaveMeAlone") "leaveMeAlone")))
