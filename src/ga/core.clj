(ns ga.core
  (:gen-class))

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
  ([n]
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

(defn evolve [population]
  population)

(defn fittest
  "Find the fittest individual"
  [population solution]
  (apply max-key (fn [x] (fitness-calc x solution)) population))

(defn optimise
  "This method takes in a binary solution and the size of initial population"
  [solution n]
  (loop [population  (populate n (count solution))
         generation  1]
    (if (= (fittest population solution) (count solution))
      generation
      (recur (evolve population) (inc generation)) )))
