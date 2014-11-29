(ns read-a-binary-number
  (:require [clojure.test :refer :all]))

;; Problem 122 - Read a binary number
;; http://www.4clojure.com/problem/122

(def __ #(Integer/parseInt % 2))

(is (= 0      (__ "0")))
(is (= 7      (__ "111")))
(is (= 8      (__ "1000")))
(is (= 9      (__ "1001")))
(is (= 255    (__ "11111111")))
(is (= 1365   (__ "10101010101")))
(is (= 65535  (__ "1111111111111111")))
