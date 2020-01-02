

(ns clojurebridge-turtle.walk
  (:use clojure.repl)
  (:use clojurebridge-turtle.core))
(init)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; On NightCode, click Run with REPL followed by Reload File
;; for the first time. If REPL has already started, click
;; Reload File to run this code.
;;
;; Once a turtle (small triangle) appears in the center of window,
;; type code in REPL.
;;
;; Alternatively, you may type code in this editor. To evaluate:
;; - pieces of code: select code fragment and Reload Selection
;; - whole file: click Reload File
;;
;; [Exercise]
;; write some functions under these comment lines
;; and evalute those
;;
;; for example
;; (forward 30)
;; (right 90)
;; (forward 30)
;; (right 90)
;;
;; see how the turtle walks
;;

;;
; Draw a sort of a house. At this point, only :trinity exists.
(forward 30)
(right 90)
(forward 30)
(right 90)
(forward 30)
(left 90)
(forward 30)
(left 90)
(forward 30)
(left 90)
(forward 30)
(left 90)
(forward 30)
(right 90)
(forward 30)
(right 90)
(forward 30)
(right 45)
(forward 30)
(right 45)
(forward 18)
(right 45)
(forward 30)
(right 45)
(forward 60)

;;
; Add a new turtle called Clare
(add-turtle :clare)

;; experiment with undo command
(undo :trinity)

;;
; bring :trinity back to the start
(home :trinity)

;;
; move trinity to a new location
(forward :trinity 100)
(right :trinity 90)
(forward :trinity 100)
(left :trinity 90)
(state :trinity)

;;
; get rid of everything trinity did up to now.
; this has the benefit of moving :trinity to a new location,
; without having a line drawn to that point.
(clean :trinity)

;;
; Get :trinity to draw the house thing again.
(forward :trinity 30)
(right :trinity 90)
(forward :trinity 30)
(right :trinity 90)
(forward :trinity 30)
(left :trinity 90)
(forward :trinity 30)
(left :trinity 90)
(forward :trinity 30)
(left :trinity 90)
(forward :trinity 30)
(left :trinity 90)
(forward :trinity 30)
(right :trinity 90)
(forward :trinity 30)
(right :trinity 90)
(forward :trinity 30)
(right :trinity 45)
(forward :trinity 30)
(right :trinity 45)
(forward :trinity 18)
(right :trinity 45)
(forward :trinity 30)
(right :trinity 45)
(forward :trinity 60)

;;
; have clare draw a house thing too, but in a different location and at a different angle.
(right :clare 180)
(forward :clare 100)
(right :clare 90)
(forward :clare 160)
(left :clare 90)
(clean :clare)
(right :clare 45)
(forward :clare 30)
(right :clare 90)
(forward :clare 30)
(right :clare 90)
(forward :clare 30)
(left :clare 90)
(forward :clare 30)
(left :clare 90)
(forward :clare 30)
(left :clare 90)
(forward :clare 30)
(left :clare 90)
(forward :clare 30)
(right :clare 90)
(forward :clare 30)
(right :clare 90)
(forward :clare 30)
(right :clare 45)
(forward :clare 30)
(right :clare 45)
(forward :clare 18)
(right :clare 45)
(forward :clare 30)
(right :clare 45)
(forward :clare 60)

;;
; add some more turtles and get them all pointing in different directions
(add-turtle :pawn01)
(add-turtle :pawn02)
(add-turtle :pawn03)
(add-turtle :pawn04)
(add-turtle :pawn05)
(add-turtle :pawn06)
(add-turtle :pawn07)
(add-turtle :pawn08)
(right :pawn01 (* 1 45))
(right :pawn02 (* 2 45))
(right :pawn03 (* 3 45))
(right :pawn04 (* 4 45))
(right :pawn05 (* 5 45))
(right :pawn06 (* 6 45))
(right :pawn07 (* 7 45))
(right :pawn08 (* 8 45))

;;
; move all turtles
; using doseq
(doseq [n (turtle-names)] (forward n 20))
(doseq [n (turtle-names)] (right n 20))
(doseq [n (turtle-names)] (forward n 20))

(clean-all)

; using map (has same effect)
(map #(forward % 40) (turtle-names))

(turtle-names)






; using two doseqs in one
(doseq [n (turtle-names)]
                       #_=> (right n 60)
                       #_=> (forward n 10))
; using map and juxt
;(map (juxt #(right % 60) #(forward % 10)) (turtle-names))
;([{:pawn01 {:angle 60}} {:pawn01 {:length 10}}]
;[{:pawn02 {:angle 60}} {:pawn02 {:length 30}}]
;[{:pawn03 {:angle 60}} {:pawn03 {:length 30}}]
;[{:pawn04 {:angle 60}} {:pawn04 {:length 30}}]
;[{:pawn05 {:angle 60}} {:pawn05 {:length 30}}]
;[{:pawn06 {:angle 60}} {:pawn06 {:length 30}}]
;;[{:pawn07 {:angle 60}} {:pawn07 {:length 30}}]
;[{:pawn08 {:angle 60}} {:pawn08 {:length 30}}]
;[{:clare {:angle 60}} {:clare {:length 30}}]
;[{:trinity {:angle 60}} {:trinity {:length 30}}])
;;
; second attempt at using map and juxt
;clojurebridge-turtle.walk=> (map (juxt #(right % 60) #(forward % 30)) (turtle-names))
;([{:trinity {:angle 60}} {:trinity {:length 30}}]
;[{:clare {:angle 60}} {:clare {:length 30}}]
;[{:pawn01 {:angle 60}} {:pawn01 {:length 30}}]
;[{:pawn02 {:angle 60}} {:pawn02 {:length 30}}]
;[{:pawn03 {:angle 60}} {:pawn03 {:length 30}}])

;;
; turtle names is a vector
(turtle-names)

;; defining a function
(defn forward-right
  "Moves specified turtle forward the specified distance and tilts its head"
  [turtle]
  (forward turtle 60)
  (right turtle 135))
(forward-right :clare)
;
(defn forward-right-with-len-ang
  "Moves specified turtle forward the specified distance and tilts its head the specified angle"
  [turtle len ang]
  (forward turtle len)
  (right turtle ang))
(forward-right-with-len-ang :clare 60 120)

;;
; using the map function
; this applies the name function to every member of the turtle-names collection
; The name function returns the name String of a string, symbol or keyword.
(map name (turtle-names))
(turtle-names)

;; using a let statement in a function:
(defn opposite
  "Given a collection of turtle names, moves two of them in different directions."
  [names]
  (let [t1 (first names)
        t2 (last names)]
    (forward t1 40)
    (backward t2 30)))

; call the function:
(opposite (turtle-names))


(clojure.repl/doc forward)



