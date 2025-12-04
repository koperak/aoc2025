(ns aoc2025.day01
  (:gen-class)
  (:require
   [clojure.java.io :as io]
   [clojure.string :as string]))


(defn rotate [position [dir step]]
  (case dir
    "L" [(mod (- position step) 100) (quot (- position step) 100)]
    "R" [(mod (+ position step) 100) (quot (- position step) 100)]))

(defn part1
  [input]
  (count
   (filter zero?
           (reductions rotate 50 (->> (string/split-lines input)
                                      (map #(re-matches #"(L|R{1})(\d+)" %))
                                      (map (fn [[_ dir step]] (vector dir (Long/parseLong step)))))))))
(defn part2
  [input]
  ;; tu logika dla części 2
  (apply + (map int input)))


(comment
  (rotate (rotate 50 ["L" 68]) ["L" 30])

  (defn dial-path
    [start dir steps]
    (let [start (mod start 100)
          sign  (case dir
                  "R"  1
                  "L" -1)]
      ;; reductions robi: start -> (start+sign) -> (start+2*sign) -> ...
      ;; My bierzemy TYLKO kolejne kroki, czyli drop 1.
      (->> (reductions
            (fn [pos _]
              (mod (+ pos sign) 100))
            start
            (range steps))
           (next))))   ;; usuwamy pozycję startową

  (print (dial-path 50 "L" 68)))

(-> (slurp (io/resource "day01/input"))
    part1)