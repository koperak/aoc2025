(ns aoc2025.day01
  (:gen-class)
  (:require
   [clojure.java.io :as io]
   [clojure.string :as string]))


(defn rotate [position [dir step]]
  (case dir
    "L" (mod (- position step) 100)
    "R" (mod (+ position step) 100)))

#dbg
 (defn part1
   [input]
   (->> input
        string/split-lines
        (map #(re-matches #"(L|R)(\d+)" %))
        (map (fn [[_ dir step]] [dir (Long/parseLong step)]))
        (reductions rotate 50)
        (filter zero?)
        count))

#dbg
 (part1 test-input)

(defn rotate-once [position dir]
  (case dir
    "L" (mod (dec position) 100)
    "R" (mod (inc position) 100)))

(defn parse-instructions
  [input]
  (->> input
       string/split-lines
       (map #(re-matches #"(L|R)(\d+)" %))

       (map (fn [[_ dir step]] [dir (Long/parseLong step 10)]))))

(def test-input "L68
L30
R48
L5
R60
L55
L1
L99
R14
L82")

(defn iterate-steps-from-start-count-zeros
  [start [dir step]]
  (->> (iterate #(rotate-once % dir) start)
       (drop 1)
       (take step)
       (filter zero?)
       (count)))

(iterate-steps-from-start-count-zeros 50 ["L" 68])

(defn part2
  [input]
  (->> input
       (parse-instructions)))

(-> (slurp (io/resource "day01/input"))
    part1)

(->> (slurp (io/resource "day01/input"))
     parse-instructions)
