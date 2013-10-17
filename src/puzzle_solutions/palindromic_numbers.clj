(ns puzzle-solutions.palindromic-numbers)

;; Problem 150 - Palindromic Numbers
;; http://www.4clojure.com/problem/150

(defn pals [n]
  (let [to-d (fn [n] (map #(- (int %) 48) (str n)))
        to-n (fn [d] (reduce #(+ (* 10 %) %2) 0 d))
        half (fn [d] (take (/ (count d) 2) d))
        reflect (fn [h d] (concat h (reverse (if (even? (count d)) h (butlast h)))))
        next-p (fn [p]
                 (let [d (to-d p)
                       h (-> d half to-n inc to-d)]
                   (if (apply = 9 d)
                     (+ p 2)
                     (to-n (reflect h d)))))
        make-p (fn [n] (-> n to-d half to-n dec to-d (reflect (to-d n)) to-n))
        first-p (fn [n] (if (zero? n) 0
                          (first (drop-while #(< % n) (iterate next-p (make-p n))))))]
    (iterate next-p (first-p n))))

(take 26 (pals 1234550000))
(take 26 (pals 0))
(take 16 (pals 162))
