package com.bielaszewski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {
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
}
