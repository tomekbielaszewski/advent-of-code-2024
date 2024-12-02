package com.bielaszewski;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @Test
    void solve1test() {
        String input = Advent.read("day2test");
        assertEquals(2, new Day2().solve1(input));
    }

    @Test
    void solve1() {
        String input = Advent.read("day2input");
        System.out.println(new Day2().solve1(input));
    }

    @Test
    void solve2test() {
        String input = Advent.read("day2test");
        assertEquals(4, new Day2().solve2(input));
    }

    @Test
    void solve2() {
        String input = Advent.read("day2input");
        System.out.println(new Day2().solve2(input));
    }
}