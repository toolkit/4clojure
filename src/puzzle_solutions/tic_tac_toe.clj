(ns puzzle-solutions.tic-tac-toe)

;; Problem 73 - Tic Tac Toe
(defn ttt [b]
  (letfn [(win [k]
            (some #(every? #{k} %)
              (concat b                                                    ; original board
                (apply map vector b)                                       ; transposed
                (vector (map #(nth %1 %2) b (range 3)))                    ; 1st diagonal
                (vector (map #(nth %1 %2) b (reverse (range 3)))))))]      ; 2nd diagonal
    (cond
      (win :x) :x
      (win :o) :o)))

(ttt [[:e :e :e]
      [:e :e :e]
      [:e :e :e]])

(ttt [[:x :e :o]
      [:x :e :e]
      [:x :e :o]])

(ttt [[:e :x :e]
      [:o :o :o]
      [:x :e :x]])

(ttt [[:x :e :e]
      [:o :x :o]
      [:x :e :x]])
