(ns ga.algo
  (:require [ga.core :as core]) )

(def *tournament-size* 5)
(def *uniform-rate* (double 0.5))
(def *mutation-rate* (double 0.015))
(def elitism? true)

(defn tournament
  "This method chooses an individual from the given population for tournament selection with tournament population of size pool"
  [population solution]
  (core/fittest (take *tournament-size* (shuffle population)) solution))

(defn mutate
  "This method randomly mutates a given individual at *mutation-rate*"
  [individual]
  (reduce str (map (fn [gene] (if (<= (rand 1) *mutation-rate*) (core/coin-flip) gene)) individual)))

(defn crossover
  "This method generates a new individual with gene crossover at *uniform-rate*"
  [individual1 individual2]
  (reduce str (map (fn [gene1 gene2] (if (<= (rand 1) *uniform-rate*) gene1 gene2 )) individual1 individual2)))

(defn evolve
  "This method generates a new population by mutation and crossover"
  [population solution]
  (let [fittest (core/fittest population solution)]
    (assoc (into [] (map (fn [x] (mutate (crossover (tournament population solution) (tournament population solution)))) population)) 0 fittest)))
