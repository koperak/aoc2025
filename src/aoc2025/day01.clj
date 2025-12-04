(ns aoc2025.day01
  (:gen-class)
  (:require
   [clojure.java.io :as io]
   [clojure.string :as string]))


(defn rotate [position [dir step]]
  (case dir
    "L" (mod (- position step) 100)
    "R" (mod (+ position step) 100)))

(rotate (rotate 50 ["L" 68]) ["L" 30])

(defn part1
  [input]
  (count (filter zero? (reductions rotate 50 (->> (string/split-lines input)
                                                  (map #(re-matches #"(L|R{1})(\d+)" %))
                                                  (map (fn [[_ dir step]] (vector dir (Long/parseLong step)))))))))
(defn part2
  [input]
  ;; tu logika dla części 2
  (apply + (map int input)))


(-> (slurp (io/resource "day01/input"))
    part1)