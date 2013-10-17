(ns puzzle-solutions.triangle-minimal-path)

;; Problem 79 - Triangle Minimal Path

(def x '([1]
        [2 4]
       [5 1 4]
      [2 3 4 5]))

(def x '([3]
        [2 4]
       [1 9 3]
      [9 9 2 4]
     [4 6 6 7 8]
    [5 7 3 5 1 4]))

(def x '([1]
        [2 2]
       [3 2 4]
      [3 3 3 1]
     [3 3 3 1 4]
    [1 7 3 3 2 7]
   [1 2 2 3 3 2 4]))

(defn mp [tri]
  (letfn [(paths
            ([n] (paths n 0))
            ([n idx]
               (if (= n 1)
                 [[idx]]
                 (map #(cons idx %)
                      (concat
                       (paths (dec n) idx)
                       (paths (dec n) (inc idx)))))))]
    (first (sort (map (fn [path] (reduce + (map (fn [row idx] (get row idx)) tri path))) (paths (count tri)))))))

(mp x)
