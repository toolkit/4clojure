(ns tricky-card-games.core
  (:require [clojure.test :refer :all]))

;; Problem 141 - Tricky Card Games
;; http://www.4clojure.com/problem/141

(def __
  (fn [trumps]
    (fn [cards]
      (last (sort-by :rank (filter #(= (or trumps (:suit (first cards))) (:suit %)) cards))))))

(deftest tests
  (is (let [notrump (__ nil)]
        (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
                                                 {:suit :club :rank 9}]))
             (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                                 {:suit :club :rank 10}])))))
  (is (= {:suit :club :rank 10} ((__ :club) [{:suit :spade :rank 2}
                                             {:suit :club :rank 10}])))
  (is (= {:suit :heart :rank 8}
         ((__ :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                       {:suit :diamond :rank 10} {:suit :heart :rank 4}]))))
