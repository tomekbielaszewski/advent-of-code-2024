package com.bielaszewski;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Advent {
    public static String read(String file) {
        URL day1input = Advent.class.getClassLoader().getResource(file);
        try {
            return Files.readString(Paths.get(Objects.requireNonNull(day1input).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}