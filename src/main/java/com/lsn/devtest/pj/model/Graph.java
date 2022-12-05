package com.lsn.devtest.pj.model;

import static java.util.stream.Collectors.toList;

import java.util.*;

public class Graph {
    private final SortedSet<Integer> vertices = new TreeSet<>(Integer::compare);

    public Graph(List<Integer> integers) {
        vertices.addAll(integers);
    }

    /** Parses string containing integers into {@code Graph} with list of vertices. */
    public static Graph parse(String integers) {
        List<Integer> parsed =
                Arrays.stream(integers.split("\\s+")).map(Integer::parseInt).collect(toList());

        return new Graph(parsed);
    }

    public boolean merge(Graph other) {
        if (other.vertices.stream().anyMatch(vertices::contains))
            return vertices.addAll(other.vertices);
        return false;
    }
}
