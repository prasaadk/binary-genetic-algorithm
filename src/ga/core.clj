(ns ga.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn fitness-calc
  [individual solution]
  "This method returns number of matching bits in the individual and the solution. This method makes an assumption that individual and solution will be of the same length"
  ((frequencies (map (fn [a b] (cond
                             (= a b) 1
                             :else 0)) individual solution)) 1))
