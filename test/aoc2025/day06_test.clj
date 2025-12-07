(ns aoc2025.day06-test
  (:require [clojure.test :refer :all]
            [aoc2025.day06 :as day06]))


(deftest day06-test
  (let [test-input "123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  "]

    (testing "parse-problems"
      (is (= '(("*" "6" "45" "123") ("+" "98" "64" "328") ("*" "215" "387" "51") ("+" "314" "23" "64")) (day06/parse-problems test-input))))

    (testing "solve-one-problem for part 1"
      (is (= 33210 (day06/solve-problem '("*" "6" "45" "123")))))

    (testing "columns index identification by last line"
      (is (= '([0 \*] [4 \+] [8 \*] [12 \+]) (day06/identify-columns "*   +   *   +  "))))))
