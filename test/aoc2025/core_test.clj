(ns aoc2025.core-test
  (:require [clojure.test :refer :all]
            [aoc2025.day01 :as day01]
            [aoc2025.day02 :as day02]
            [aoc2025.day03 :as day03]))

(deftest day01
  (testing "part1"
    (let [test-input "L68
L30
R48
L5
R60
L55
L1
L99
R14
L82"   ;; dane testowe tu
          expected 3]                     ;; oczekiwany wynik
      (is (= expected (day01/part1 test-input)))))

  (testing "part2"
    (let [test-input "ABC"
          expected   198]                    ;; przykładowa wartość
      (is (= expected (day01/part2 test-input))))))
