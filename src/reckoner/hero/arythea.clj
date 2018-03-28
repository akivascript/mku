(ns reckoner.hero.arythea
  (:require [clojure.spec.alpha :as s]))

(def deck
  [:red :red :blue :white :white :green :green :blue
   :blue :green :white :red :blue :white :green :red])

(def crystals
  {:blue 0
   :green 0
   :red 2
   :white 1})
