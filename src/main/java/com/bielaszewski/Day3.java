package com.bielaszewski;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 implements Advent.OfCode {

    private final String mulStart = "mul(";
    private final String enabler = "do()";
    private final String disabler = "don't()";
    private final char mulEnd = ')';
    private final char mulSep = ',';

    @Override
    public int solve1(String input) {
        List<Integer> numbers = new ArrayList<>();
        char[] input_ = input.toCharArray();

        for (int i = 0; i < input_.length; i++) {
            i = nextMul(i, input_);
            if (i == -1) break;
            if (i >= input_.length) break;

            NumberDetection nd1 = nextNum(i, input_);
            if (!nd1.detected) continue;
            if (nd1.endIndex >= input_.length) break;
            if (input_[nd1.endIndex] != mulSep) continue;
            i = nd1.endIndex + 1;

            NumberDetection nd2 = nextNum(i, input_);
            if (!nd2.detected) continue;
            if (nd2.endIndex >= input_.length) break;
            if (input_[nd2.endIndex] != mulEnd) continue;
            i = nd2.endIndex;

            numbers.add(nd1.num * nd2.num);
        }

        return numbers.stream().reduce(0, Integer::sum);
    }

    private NumberDetection nextNum(int index, char[] input) {
        List<Character> numChars = new ArrayList<>();
        for (int i = index; i < input.length; i++) {
            char c = input[i];
            if (Character.isDigit(c)) numChars.add(c);
            else break;
        }
        NumberDetection nd = new NumberDetection();
        nd.detected = !numChars.isEmpty();
        nd.endIndex = index + numChars.size();
        nd.num = Integer.parseInt(numChars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));
        return nd;
    }

    private int nextMul(int index, char[] input) {
        for (int i = index; i < input.length; i++) {
            if (isMul(i, input)) return i + mulStart.length();
        }
        return -1;
    }

    private boolean isMul(int index, char[] input) {
        return isWord(mulStart, index, input);
    }

    private class NumberDetection {
        boolean detected;
        int num;
        int endIndex;
    }

    @Override
    public int solve2(String input) {
        List<Integer> numbers = new ArrayList<>();
        char[] input_ = input.toCharArray();
        boolean isEnabled = true;

        for (int i = 0; i < input_.length; i++) {
            if (isEnabled && isMul(i, input_)) {
                i = nextMul(i, input_);
                if (i == -1) break;
                if (i >= input_.length) break;

                NumberDetection nd1 = nextNum(i, input_);
                if (!nd1.detected) continue;
                if (nd1.endIndex >= input_.length) break;
                if (input_[nd1.endIndex] != mulSep) continue;
                i = nd1.endIndex + 1;

                NumberDetection nd2 = nextNum(i, input_);
                if (!nd2.detected) continue;
                if (nd2.endIndex >= input_.length) break;
                if (input_[nd2.endIndex] != mulEnd) continue;
                i = nd2.endIndex;

                numbers.add(nd1.num * nd2.num);
            }
            if (isEnabled && isDont(i, input_)) {
                isEnabled = false;
                i += disabler.length() - 1;
            }
            if (!isEnabled && isDo(i, input_)) {
                isEnabled = true;
                i += enabler.length() - 1;
            }
        }

        return numbers.stream().reduce(0, Integer::sum);
    }

    private boolean isDont(int index, char[] input) {
        return isWord(disabler, index, input);
    }

    private boolean isDo(int index, char[] input) {
        return isWord(enabler, index, input);
    }

    private boolean isWord(String word, int index, char[] input) {
        for (int i = 0; i < word.length() && index + i < input.length; i++) {
            if (input[index + i] != word.charAt(i)) return false;
        }
        return true;
    }
}
