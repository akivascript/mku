(ns recokoner.dummy
  (:require [clojure.spec.alpha :as s]))

(s/def ::crystal #{:black :gold :blue :green :red :white})
(s/def ::hero #{:Arythea :Goldyx :Norowas :Tovak :Wolfhawk})
(s/def ::order (s/and int? pos?))
(s/def ::card (s/and pos? #(<= % 16)))
(s/def ::deeds (s/and set? (s/coll-of ::card)))
(s/def ::turn (s/and pos? #(<= % 6)))

(def dummy
  {::hero nil
   ::crystals nil
   ::turn 1
   ::cards (into #{} (mapv inc (range 16)))
   })

(defn tactic
  [d]
  (update d ::turn #(inc (rand-int 6))))

(defn end-turn
  [d]

  )

(defn play
  [d]
  (when (empty? (::cards d))
    (end-turn d))
  (mapi)
  ) 
