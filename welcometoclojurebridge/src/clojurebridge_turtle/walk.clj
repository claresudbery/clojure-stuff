

(ns clojurebridge-turtle.walk
  (:use clojure.repl)
  (:use clojurebridge-turtle.core))
(init)

(add-turtle :clare)
(add-turtle :rebecca)
(add-turtle :eve)

; map: apply a function to all in collection
(map right (turtle-names) [0 90 180 270])
(map right (turtle-names) [45 45 45 45])
(map right (turtle-names) [22.5 22.5 22.5 22.5])

(clean-all)
(map home (turtle-names))

(defn walk-in-square
  [turtle square-width]
  (forward turtle square-width)
  (left turtle 90)
  (forward turtle square-width)
  (left turtle 90)
  (forward turtle square-width)
  (left turtle 90)
  (forward turtle square-width)
  (left turtle 90))

(map backward (turtle-names) [30 30 30 30])
(map forward (turtle-names) [30 30 30 30])

(defn all-walk-in-square2
  [square-width]
(map walk-in-square (turtle-names)
     (repeat (count (turtle-names)) square-width)))
; call the function
(map all-walk-in-square2 [10 20 30 40 50 60 70 80 90])
(map all-walk-in-square2 [5 10 15 20 25 30 35 40 45 50 55 60 65])
(map all-walk-in-square2 [2 4 6 8 10 12 14 16 18 20 22 24 26])
(map all-walk-in-square2 (map * [2 4 6 8 10 12 14 ] [2 4 6 8 10 12 14]))
(map all-walk-in-square2 (map * [2 4 6 8 10 12 14 ] [1 2 3 4 5 6 7]))


(defn all-walk-in-square
  [square-width]
(map walk-in-square (turtle-names)
     [square-width square-width square-width square-width]))

  (count (turtle-names))

  (map * [2 4 6 8 10] [1 2 3 4 5])




(turtle-names)
