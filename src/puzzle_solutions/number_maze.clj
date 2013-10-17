(ns puzzle-solutions.number-maze)

;; Problem 106 - Number Maze
;; http://www.4clojure.com/problem/106

(defn maze [x y]
  (loop [now [x]
         len 1]
    ;;(println now)
    (if (some #{y} now)
      len
      (recur (mapcat #(if (even? %)
                        (vector (* % 2) (/ % 2) (+ % 2))
                        (vector (* % 2) (+ % 2)))
                     now) (inc len)))))

(print (maze 31 22))
