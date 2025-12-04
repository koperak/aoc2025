(ns aoc2025.day02
  (:gen-class))

(defn part1
  [input]
  ;; tu logika dla części 1, input np. string z liniami
  (count input))

(defn part2
  [input]
  ;; tu logika dla części 2
  (apply + (map int input)))