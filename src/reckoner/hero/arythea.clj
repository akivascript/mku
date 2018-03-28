(ns reckoner.hero.arythea
  (:require [clojure.spec.alpha :as s]))

(def deck
  [:red :red :blue :white :white :green :green :blue
   :blue :green :white :red :blue :white :green :red])

(def crystals
  [{::crystal :blue
    ::count 0}
   {::cyrstal :green
    ::count 0}
   {::crystal :red
    ::count 2}
   {::crystal :white
    ::count 1}])
