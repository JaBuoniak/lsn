package com.lsn.devtest.pj.model;

import static java.util.stream.Collectors.toList;

import java.util.*;

/** Set of connected vertices sorted ascending */
public class Graph {
    private final SortedSet<Integer> vertices = new TreeSet<>(Integer::compare);

    public Graph(List<Integer> integers) {
        vertices.addAll(integers);
    }

    public Graph(Graph graph) {
        vertices.addAll(graph.vertices);
    }

    /** Compares {@code Graph}s according to the lowest vertex value. */
    public static int compare(Graph g1, Graph g2) {
        return g1.vertices.first().compareTo(g2.vertices.first());
    }

    /** Parses string containing integers into {@code Graph} with list of vertices. */
    public static Graph parse(String integers) {
        List<Integer> parsed =
                Arrays.stream(integers.split("\\s+")).map(Integer::parseInt).collect(toList());

        return new Graph(parsed);
    }

    /**
     * Merges other {@code Graph} into current if they have any common vertex.
     * @return {@code true} if graphs had at least one common vertex
     */
    public boolean merge(Graph other) {
        if (other.vertices.stream().anyMatch(vertices::contains)) {
            vertices.addAll(other.vertices);
            return true;
        }
        return false;
    }
}
