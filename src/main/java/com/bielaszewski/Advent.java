package com.bielaszewski;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Advent {
    public interface OfCode {
        int solve1(String input);

        int solve2(String input);
    }

    public static String read(String file) {
        URL input = Advent.class.getClassLoader().getResource(file);
        if (input == null) {
            throw new IllegalStateException("You've forgot to create the input file: " + file);
        }
        try {
            return Files.readString(Paths.get(Objects.requireNonNull(input).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static Stream<String> splitLines(String input) {
        return Arrays.stream(input.split("\r\n"));
    }
}
