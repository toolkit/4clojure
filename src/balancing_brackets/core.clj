(ns balancing-brackets.core
  (:require [clojure.test :refer :all]))

;; Problem 177 - Balancing Brackets
;; http://www.4clojure.com/problem/177

(def __ #(let [a (clojure.string/replace % #"[^\(^\)^\[^\]^\{^\}]" "")
       b (clojure.string/replace a #"(\(\)|\[\]|\{\})" "")]
   (if (empty? b)
     true
     (if (= b %)
       false
       (recur b)))))

(deftest tests
  (is (__ "This string has no brackets."))
  (is (__ "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }"))
  (is (not (__ "(start, end]")))
  (is (not (__ "())")))
  (is (not (__ "[ { ] } ")))
  (is (__ "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))"))
  (is (not (__ "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))")))
  (is (not (__ "["))))
