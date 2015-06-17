(ns for-science.core
  (:require [clojure.test :refer :all]))

;; Problem 117 - For Science!
;; https://www.4clojure.com/problem/117


(def __ (fn [maze]
          (let [move (fn [[row col]]
                       [[(dec row) col]
                        [row (dec col)]
                        [row (inc col)]
                        [(inc row) col]])
                find-mouse (fn [maze]
                             (first (keep-indexed
                                      (fn [row contents]
                                        (let [col (.indexOf contents "M")]
                                          (if (not (neg? col)) [row col]))) maze)))
                next-moves (fn [cells]
                             (mapcat move cells))
                valid-moves (fn [new maze]
                              (filter #(#{\space \M \C} (get-in maze %)) new))
                grow (fn [cells maze]
                       (let [new (next-moves cells)
                             valid (valid-moves new maze)]
                         (into #{} (concat cells valid))))
                reached-cheese (fn [cells maze]
                                 (some #{\C} (map #(get-in maze %) cells)))
                start (find-mouse maze)]
            (loop [old #{start}]
              (let [new (grow old maze)]
                (cond
                  (= new old) false
                  (reached-cheese new maze) true
                  :else (recur new)))))))

(deftest tests
  (is (= true (__ ["M   C"])))
  (is (= false (__ ["M # C"])))
  (is (= true (__ ["#######"
                   "#     #"
                   "#  #  #"
                   "#M # C#"
                   "#######"])))
  (is (= false (__ ["########"
                    "#M  #  #"
                    "#   #  #"
                    "# # #  #"
                    "#   #  #"
                    "#  #   #"
                    "#  # # #"
                    "#  #   #"
                    "#  #  C#"
                    "########"])))
  (is (= false (__ ["M     "
                    "      "
                    "      "
                    "      "
                    "    ##"
                    "    #C"])))
  (is (= true (__ ["C######"
                   " #     "
                   " #   # "
                   " #   #M"
                   "     # "])))
  (is (= true (__ ["C# # # #"
                   "        "
                   "# # # # "
                   "        "
                   " # # # #"
                   "        "
                   "# # # #M"]))))