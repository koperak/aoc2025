(ns aoc2025.core-test
  (:require [clojure.test :refer :all]
            [aoc2025.day01 :as day01]
            [aoc2025.day02 :as day02]
            [aoc2025.day03 :as day03]))


(deftest day01-test
  (let [test-input "L68
L30
R48
L5
R60
L55
L1
L99
R14
L82"]
    (testing "part1"
      (let [expected 3]
        (is (= expected (day01/part1 test-input)))))

    (testing "rotate once"
      (is (= 99 (day01/rotate-once 0 "L")))
      (is (= 1 (day01/rotate-once 0 "R")))
      (is (= 0 (day01/rotate-once 1 "L")))
      (is (= 0 (day01/rotate-once 99 "R"))))

    (testing "part2-multiple-cases"
      (is (= 3 (day01/part2 "L310")))
      (is (= 1 (day01/part2 "L68")))
      (is (= 0 (day01/part2 "R34")))
      (is (= 3 (day01/part2 "R310"))))

    (testing "part2"
      (let [expected 6]
        (is (= expected (day01/part2 test-input)))))))