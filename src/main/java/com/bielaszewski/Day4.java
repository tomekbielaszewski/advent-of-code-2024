package com.bielaszewski;

public class Day4 implements Advent.OfCode {
    private final String XMAS = "XMAS";
    private final String SAMX = "SAMX";

    @Override
    public int solve1(String input) {
        String[] lines = Advent.splitLines(input).toArray(String[]::new);
        int occurences = 0;
        occurences += searchHorizontal(XMAS, lines);
        occurences += searchVertical(XMAS, lines);
        occurences += searchDiagonalDown(XMAS, lines);
        occurences += searchDiagonalUp(XMAS, lines);
        occurences += searchHorizontal(SAMX, lines);
        occurences += searchVertical(SAMX, lines);
        occurences += searchDiagonalDown(SAMX, lines);
        occurences += searchDiagonalUp(SAMX, lines);
        return occurences;
    }

    private int searchHorizontal(String word, String[] lines) {
        int counter = 0;
        for (int y = 0; y < lines.length; y++) {
            char[] line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                boolean found = false;
                char c = word.charAt(0);
                if (checkAt(c, x, y, lines)) {
                    found = true;
                    for (int w = 1; w < word.length(); w++) {
                        found = found && checkAt(word.charAt(w), x + w, y, lines);
                        if (!found) break;
                    }
                }
                if (found) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int searchVertical(String word, String[] lines) {
        int counter = 0;
        for (int y = 0; y < lines.length; y++) {
            char[] line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                boolean found = false;
                char c = word.charAt(0);
                if (checkAt(c, x, y, lines)) {
                    found = true;
                    for (int w = 1; w < word.length(); w++) {
                        found = found && checkAt(word.charAt(w), x, y + w, lines);
                        if (!found) break;
                    }
                }
                if (found) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int searchDiagonalDown(String word, String[] lines) {
        int counter = 0;
        for (int y = 0; y < lines.length; y++) {
            char[] line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                boolean found = false;
                char c = word.charAt(0);
                if (checkAt(c, x, y, lines)) {
                    found = true;
                    for (int w = 1; w < word.length(); w++) {
                        found = found && checkAt(word.charAt(w), x + w, y + w, lines);
                        if (!found) break;
                    }
                }
                if (found) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int searchDiagonalUp(String word, String[] lines) {
        int counter = 0;
        for (int y = 0; y < lines.length; y++) {
            char[] line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                boolean found = false;
                char c = word.charAt(0);
                if (checkAt(c, x, y, lines)) {
                    found = true;
                    for (int w = 1; w < word.length(); w++) {
                        found = found && checkAt(word.charAt(w), x + w, y - w, lines);
                        if (!found) break;
                    }
                }
                if (found) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean checkAt(char c, int x, int y, String[] lines) {
        if (y < 0 || x < 0) return false;
        if (y >= lines.length) return false;
        if (x >= lines[y].length()) return false;
        return lines[y].charAt(x) == c;
    }

    @Override
    public int solve2(String input) {
        String[] lines = Advent.splitLines(input).toArray(String[]::new);
        int counter = 0;
        for (int y = 0; y < lines.length; y++) {
            char[] line = lines[y].toCharArray();
            for (int x = 0; x < line.length; x++) {
                boolean found = false;
                if (checkAt('A', x, y, lines)) {
                    found = (checkAt('M', x-1,y-1, lines) && checkAt('S', x+1,y+1, lines) ||
                            checkAt('S', x-1,y-1, lines) && checkAt('M', x+1,y+1, lines)) &&
                            (checkAt('M', x-1,y+1, lines) && checkAt('S', x+1,y-1, lines) ||
                                    checkAt('S', x-1,y+1, lines) && checkAt('M', x+1,y-1, lines));
                }
                if (found) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
