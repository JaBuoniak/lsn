package com.lsn.devtest.pj;

import com.lsn.devtest.pj.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Processor {
    public static int process(List<String> input) {
        // Each pair of vertices becomes separate graph
        List<Graph> graphs = input.stream().map(Graph::parse).sorted(Graph::compare).collect(Collectors.toList());
        List<Graph> mergedGraphs = new ArrayList<>();

        for (Graph graph : graphs) {
            mergeOrAdd(graph, mergedGraphs);
        }

        return mergedGraphs.size();
    }

    private static void mergeOrAdd(Graph graph, List<Graph> mergedGraphs) {
        for (Graph mergedGraph : mergedGraphs) {
            if (mergedGraph.merge(graph))
                return;
        }
        mergedGraphs.add(graph);
    }
}
