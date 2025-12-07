(ns aoc2025.day06
  (:gen-class)
  (:require
   [clojure.string :as str]
   [clojure.java.io :as io]))

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

(solve-problem '("*" "123" "45" "6"))

(def test-input "123 328  51 64 
45 64  387 23 
6 98  215 314
*   +   *   +  ")

(->> test-input
     parse-problems
     (map solve-problem)
     (apply +))

(->> (slurp (io/resource "day06/input"))
     parse-problems
     (map solve-problem)
     (apply +))