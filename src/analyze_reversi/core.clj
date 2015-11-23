(ns analyze-reversi.core
  (:use [midje.sweet]))

;; Problem 124 - Analyze reversi
;; http://www.4clojure.com/problem/124

(def __ (fn [x y] false))

(facts "about reversi"
       (__ '[[e e e e]
             [e w b e]
             [e b w e]
             [e e e e]] 'w) => {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
       (__ '[[e e e e]
             [e w b e]
             [w w w e]
             [e e e e]] 'b) => {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
       (__ '[[e e e e]
             [e w b e]
             [w w b e]
             [e e b e]] 'w) => {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
       (__ '[[e e w e]
             [b b w e]
             [b w w e]
             [b w w w]] 'b) => {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}})
