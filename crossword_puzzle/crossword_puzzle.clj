(ns crossword-puzzle
  (:require [clojure.test :refer :all]))

;; Problem 111 - Crossword Puzzle
;; http://www.4clojure.com/problem/111

(def __ (fn [word matrix]
          (let [remove-spaces      (fn [matrix]
                                     (map #(clojure.string/replace % " " "") matrix))
                transpose          (fn [matrix]
                                     (apply map str matrix))
                make-pattern       (fn [word]
                                     (re-pattern
                                      (apply str
                                             (concat "(^|#)"
                                                     (map #(str "(_|" % ")") word)
                                                     "(#|$)"))))
                matrix (remove-spaces matrix)
                transposed (transpose matrix)
                pattern (make-pattern word)]
            (not (nil?
                  (or (some #(re-find pattern %) matrix)
                      (some #(re-find pattern %) transposed)))))))

(deftest tests
  (is (= true  (__ "the" ["_ # _ _ e"])))
  (is (= false (__ "the" ["c _ _ _"
                          "d _ # e"
                          "r y _ _"])))
  (is (= true  (__ "joy" ["c _ _ _"
                          "d _ # e"
                          "r y _ _"])))
  (is (= false (__ "joy" ["c o n j"
                          "_ _ y _"
                          "r _ _ #"])))
  (is (= true  (__ "clojure" ["_ _ _ # j o y"
                              "_ _ o _ _ _ _"
                              "_ _ f _ # _ _"]))))
