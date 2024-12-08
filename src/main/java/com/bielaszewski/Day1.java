package com.bielaszewski;

import java.util.*;

public class Day1 implements Advent.OfCode {
    public int solve1(String input) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        Arrays.stream(input.split("\r\n"))
                .map(l -> l.split("   "))
                .forEach(ls -> {
                    left.add(Integer.parseInt(ls[0]));
                    right.add(Integer.parseInt(ls[1]));
                });

        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        int distance = 0;
        for (int i = 0; i < left.size(); i++) {
            distance += Math.abs(left.get(i) - right.get(i));
        }
        return distance;
    }

    public int solve2(String input) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        Arrays.stream(input.split("\r\n"))
                .map(l -> l.split("   "))
                .forEach(ls -> {
                    left.add(Integer.parseInt(ls[0]));
                    right.add(Integer.parseInt(ls[1]));
                });

        Map<Integer, Integer> rightOccurrences = new HashMap<>();

        for (Integer i : right) {
            rightOccurrences.put(i, 1 + rightOccurrences.getOrDefault(i, 0));
        }

        var similarity = 0;
        for (int i = 0; i < left.size(); i++) {
            var iLeft = left.get(i);

            var leftNumberOccurrencesInRightList = rightOccurrences.getOrDefault(iLeft, 0);

            similarity += iLeft * leftNumberOccurrencesInRightList;
        }

        return similarity;
    }
}
