(ns drawing.lines
  (:require [quil.core :as q]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (q/stroke 255 0 0))

(defn draw []
  (q/stroke (q/mouse-x) 0 0)
  (q/line 10 10 (q/mouse-x) (q/mouse-y))
  (q/stroke 7 12 (q/mouse-y))
  (q/line 200 10 (q/mouse-x) (q/mouse-y))
  (q/stroke 0 0 255)
  (q/line 10 200 (q/mouse-x) (q/mouse-y))
  (q/stroke 0 255 0)
  (q/line 200 200 (q/mouse-x) (q/mouse-y)))

(q/defsketch hello-lines
  :title "You can see lines"
  :size [500 500]
  :setup setup
  :draw draw
  :features [:keep-on-top])

(def y 40)
(if (< (+ y 40) 150)
  (+ y 40)
  -150)