(ns ga.core
  (:gen-class)
  (:require [ga.algo :as algo]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn fitness-calc
  "This method returns number of matching bits in the individual and the solution. This method makes an assumption that individual and solution will be of the same length"  
  [individual solution]
  ((frequencies (map (fn [a b] (cond
                             (= a b) 1
                             :else 0)) individual solution)) 1))

(defn coin-flip
  "This method flips a coin and returns either 1 or 0"
  ([x]
     (str (rand-int 2)))
  ([]
     (str (rand-int 2))))

(defn generate-individual
  "This method generates a binary string of size n"
  [n]
  (reduce str (map coin-flip (range n))))

(defn populate
  "This method generates a sequences of n unique individuals of length size "
  [n size]
  (map (fn [x] (generate-individual size)) (range n)))

(defn fittest
  "Find the fittest individual"
  [population solution]
  (apply max-key (fn [x] (fitness-calc x solution)) population))

(defn optimise
  "This method takes in a binary solution and the size of initial population"
  [solution n]
  (loop [population  (populate n (count solution))
         generation  1]
    (let [fit (fittest population solution)]
      (if (= fit solution)
        (do
          (print (str "Generate " generation ": Fitness " fit "\n"))
          generation)
       (do
         (print (str "Generate " generation ": Fitness " fit "\n"))
         (recur (algo/evolve population solution) (inc generation)))))))
