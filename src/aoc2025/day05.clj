(ns aoc2025.day05
  (:gen-class)
  (:require
   [clojure.string :as str]
   [clojure.java.io :as io]))

(->> slurp (io/resource "day05/input"))