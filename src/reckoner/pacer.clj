(ns reckoner.pacer
  (:require [clojure.spec.alpha :as s]
            [reckoner.hero.arythea :as ary]))

(s/def ::count (s/and int? pos?))
(s/def ::crystal #{:blue :green :red :white})
(s/def ::crystals (s/keys :req [::crystal
                                ::count]))
(s/def ::number (s/and pos? #(<= % 16)))
(s/def ::deed (s/keys :req [::number
                            ::crystal]))
(s/def ::deck (s/and vector? (s/coll-of ::deed)))
(s/def ::hero #{:arythea :goldyx :norowas :tovak :wolfhawk})
(s/def ::order (s/and int? (not neg?)))
(s/def ::tactic (s/and int? #(<= % 6)))
(s/def ::turn (s/and pos? #(<= % 6)))

(s/def ::pacer (s/keys :req [::hero
                             ::crystals
                             ::deeds
                             ::order
                             ::tactic]))


(def hero
  #{:arythea :goldyx :norowas :tovak :wolfhawk})

(def pacer
  {::hero nil
   ::crystals []
   ::deck nil
   ::order 0
   ::tactic 0})

(defn make-deck
  [deck]
  (into (sorted-map) (zipmap (map inc (range)) deck)))

(def arythea
  (assoc! (transient pacer)
          ::hero :arythea
          ::crystals ary/crystals
          ::deck (make-deck ary/deck)
          ::order 0
          ::tactic 0))

(def game
  {::turn 1})

(defn tactic
  [p]
  (update p ::turn #(inc (rand-int 6))))

(defn end-turn
  [p]

  )

(defn draw
  [deck]
  (let [deck (if-not (nil? (some keyword? (keys deck)))
               (:deck deck)
               deck)
        card (loop [n (inc (rand-int (count deck)))]
               (if-not (nil? (get deck n))
                 n
                 (recur (inc (rand-int (count deck))))))]
    {:color (get deck card)
     :deck (dissoc deck card)}))

(defn play
  [p]
  (when (empty? (::deck p))
    (end-turn p))
  (let [{color :color deck :deck} (last (take 4 (iterate draw deck)))]

    )) 

(defn init
  ([]
   (init (rand-nth (seq hero))))
  ([hero]
   (persistent! (assoc! dummy ::hero ))))
