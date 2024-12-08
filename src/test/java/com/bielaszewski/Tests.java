package com.bielaszewski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private Advent.OfCode[] days = new Advent.OfCode[]{
            new Day1(),
            new Day2(),
            new Day3(),
    };

    private int[] expectedTestResults = new int[]{
            11, 31, //day 1
            2, 4,   //day 2
            161, 0  //day 3
    };

    @Test
    void solve() {
        for (int i = 0; i < days.length; i++) {
            Advent.OfCode day = days[i];

            String testInput = Advent.read(String.format("day%dtest", i+1));
            int testResult1 = day.solve1(testInput);
            int expectedTestResult1 = expectedTestResults[i * 2];
            assertEquals(expectedTestResult1, testResult1, String.format("Result of 1st test on Day %d is incorrect. Expected: %d, Actual %d", i+1,expectedTestResult1, testResult1));

            String input = Advent.read(String.format("day%dinput", i+1));
            int result1 = day.solve1(input);
            System.out.printf("First star of Day %d is: %d\n", i + 1, result1);

            int testResult2 = day.solve2(testInput);
            int expectedTestResult2 = expectedTestResults[i * 2 + 1];
            assertEquals(expectedTestResult2, testResult2, String.format("Result of 2nd test on Day %d is incorrect. Expected: %d, Actual %d", i+1,expectedTestResult2, testResult2));

            int result2 = day.solve2(input);
            System.out.printf("Second star of Day %d is: %d\n", i + 1, result2);
        }
    }
}
