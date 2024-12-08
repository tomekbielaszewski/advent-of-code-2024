package com.bielaszewski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 implements Advent.OfCode {
    public int solve1(String input) {
        List<List<Integer>> reports = Advent.splitLines(input)
                .map(l -> Arrays.stream(l.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .toList();

        return (int) reports.stream()
                .filter(r -> isIncreasing(r) || isDecreasing(r))
                .filter(this::isSafelyChanging)
                .count();
    }

    private boolean isIncreasing(List<Integer> r) {
        if (r.size() < 2) return true;
        for (int i = 1; i < r.size(); i++) {
            if (r.get(i - 1) >= r.get(i)) return false;
        }
        return true;
    }

    private boolean isDecreasing(List<Integer> r) {
        if (r.size() < 2) return true;
        for (int i = 1; i < r.size(); i++) {
            if (r.get(i - 1) <= r.get(i)) return false;
        }
        return true;
    }

    private boolean isSafelyChanging(List<Integer> r) {
        if (r.size() < 2) return true;
        for (int i = 1; i < r.size(); i++) {
            int step = Math.abs(r.get(i - 1) - r.get(i));
            if (step < 1 || step > 3) return false;
        }
        return true;
    }

    public int solve2(String input) {
        List<List<Integer>> reports = Advent.splitLines(input)
                .map(l -> Arrays.stream(l.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .toList();

        return (int) reports.stream()
                .filter(r -> isIncreasingWithTolerance(r) || isDecreasingWithTolerance(r))
                .count();
    }

    private boolean isIncreasingWithTolerance(List<Integer> r) {
        if (isIncreasing(r) && isSafelyChanging(r)) return true;
        r = new ArrayList<>(r);
        for (int i = 1; i < r.size(); i++) {
            int step = r.get(i) - r.get(i - 1);
            if (step < 1 || step > 3) {
                r.remove(i - 1);
                break;
            }
        }
        return isIncreasing(r) && isSafelyChanging(r);
    }

    private boolean isDecreasingWithTolerance(List<Integer> r) {
        if (isDecreasing(r) && isSafelyChanging(r)) return true;
        r = new ArrayList<>(r);
        for (int i = 1; i < r.size(); i++) {
            int step = r.get(i - 1) - r.get(i);
            if (step < 1 || step > 3) {
                r.remove(i - 1);
                break;
            }
        }
        return isDecreasing(r) && isSafelyChanging(r);
    }
}
