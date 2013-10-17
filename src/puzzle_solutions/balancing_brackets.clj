(ns puzzle-solutions.balancing-brackets)

;; Problem 177 - Balancing Brackets
;; http://www.4clojure.com/problem/177

(#(let [a (clojure.string/replace % #"[^\(^\)^\[^\]^\{^\}]" "")
        b (clojure.string/replace a #"(\(\)|\[\]|\{\})" "")]
    (if (empty? b)
      true
      (if (= b %)
        false
        (recur b)))) "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")
