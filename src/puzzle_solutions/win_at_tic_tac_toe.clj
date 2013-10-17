(ns puzzle-solutions.win-at-tic-tac-toe)


;; Problem 119 - Win at Tic-Tac-Toe

(def puzzle [[:o :e :e]
             [:o :x :o]
             [:x :x :e]])

(defn win-at-tic-tac-toe [side board]
  (let [candidates (fn [board]
                     (for [row (range 3)
                           col (range 3)
                           :let [candidate (get-in board [row col])]
                           :when (= :e candidate)]
                       [row col]))
        check (fn [side board]
                (some #(every? #{side} %)
                      (concat board
                              (apply map vector board)
                              (vector (map #(nth %1 %2) board (range 3)))
                              (vector (map #(nth %1 %2) board (reverse (range 3)))))))]
     (set (filter #(not (nil? (check side (assoc-in board % side))))
                    (candidates board)))))

(win-at-tic-tac-toe :x puzzle)
