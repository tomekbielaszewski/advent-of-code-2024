package com.bielaszewski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private Advent.OfCode[] days = new Advent.OfCode[]{
            new Day1(),
            new Day2(),
            new Day3(),
            new Day4(),
    };

    private int[] expectedTestResults = new int[]{
            11, 31,   //day 1
            2, 4,     //day 2
            161, 48,  //day 3
            18, 0,    //day 4
    };

    private String[] inputs = new String[]{
            "day1test1", "day1test1", "day1input", //day 1
            "day2test1", "day2test1", "day2input", //day 2
            "day3test1", "day3test2", "day3input", //day 3
            "day4test1", "day4test1", "day4input", //day 4
    };

    @Test
    void solve() {
        for (int i = 0; i < days.length; i++) {
            Advent.OfCode day = days[i];

            String testInput1 = Advent.read(inputs[i * 3]);
            int testResult1 = day.solve1(testInput1);
            int expectedTestResult1 = expectedTestResults[i * 2];
            assertEquals(expectedTestResult1, testResult1, String.format("Result of 1st test on Day %d is incorrect. Expected: %d, Actual %d", i + 1, expectedTestResult1, testResult1));

            String input = Advent.read(inputs[i * 3 + 2]);
            int result1 = day.solve1(input);
            System.out.printf("Day %d! First star! --> %d\n", i + 1, result1);

            String testInput2 = Advent.read(inputs[i * 3 + 1]);
            int testResult2 = day.solve2(testInput2);
            int expectedTestResult2 = expectedTestResults[i * 2 + 1];
            assertEquals(expectedTestResult2, testResult2, String.format("Result of 2nd test on Day %d is incorrect. Expected: %d, Actual %d", i + 1, expectedTestResult2, testResult2));

            int result2 = day.solve2(input);
            System.out.printf("Day %d! Second star! --> %d\n", i + 1, result2);
        }
    }
}
