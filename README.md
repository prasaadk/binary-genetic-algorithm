# Basic Binary Genetic Algorithm in Clojure

This exercise is based upon [a very elegant explanation of Genetic Algorithms].(http://www.theprojectspot.com/tutorial-post/creating-a-genetic-algorithm-for-beginners/3).

The original implementation is in Java. I have re-implemented the same in Clojure.

## Basic Process

1. Create a random population
2. Check if any one individual meets the fitness requirement
3. If not, let the next generation evolve from the previous one
4. Evaluation simulates crossover i.e reproduction and random gene mutation
5. The genes of the fittest individual often survies via reproduction and helps further generations to reach the goal.
6. This process is repeated until the fitness requirement is met.

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
