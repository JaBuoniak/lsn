package com.lsn.devtest.pj;

import com.lsn.devtest.pj.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Processor {
    public static int process(List<String> input) {
        // Each pair of vertices becomes separate graph
        List<Graph> graphs = input.stream().map(Graph::parse).sorted(Graph::compare).collect(Collectors.toList());

        return mergeAll(graphs).size();
    }

    private static List<Graph> mergeAll(List<Graph> graphs) {
        List<Graph> mergedGraphs = new ArrayList<>();

        for (Graph graph : graphs) {
            mergeOrAdd(graph, mergedGraphs);
        }

        // Repeat till no more merge possible
        if (mergedGraphs.size() < graphs.size())
            return mergeAll(mergedGraphs);

        return mergedGraphs;
    }

    private static void mergeOrAdd(Graph graph, List<Graph> mergedGraphs) {
        for (Graph mergedGraph : mergedGraphs) {
            if (mergedGraph.merge(graph))
                return;
        }
        // Since couldn't find any graph to merge into it, becomes the new one on the result list.
        mergedGraphs.add(new Graph(graph));
    }
}
