(ns aoc2025.day06
  (:gen-class)
  (:require
   [clojure.string :as str]
   [clojure.java.io :as io]))

; part 1 - matematyka cefalopodów
(defn parse-problems
  [input]
  (->> input
       (str/split-lines)
       (map #(str/trim %))
       (map #(str/split % #"\s+"))
       (apply map vector)
       (map reverse)))

(defn solve-problem
  [problem]
  (let [ops {"+" + "*" *}
        operation (ops (first problem))
        arguments (mapv #(Integer/parseInt %) (rest problem))]
    (apply operation arguments)))

(->> (slurp (io/resource "day06/input"))
     parse-problems
     (map solve-problem)
     (apply +))

; part 2 - math is changing so code
(defn identify-columns
  [line]
  (->> line
       (map-indexed vector)
       (filter #(not= (second %) \space))))

