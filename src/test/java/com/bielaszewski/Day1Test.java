package com.bielaszewski;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void day1solve1test() {
        String input = Advent.read("day1test1");

        int distance = new Day1().solve1(input);
        assertEquals(11, distance);
    }

    @Test
    void day1solve1() throws IOException, URISyntaxException {
        int distance = new Day1().solve1(Advent.read("day1input1"));
        System.out.println(distance);
    }
}