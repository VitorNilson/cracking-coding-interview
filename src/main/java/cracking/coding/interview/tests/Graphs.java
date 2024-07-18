package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.Graph;

import java.util.*;

public class Graphs<T> {

    //    4.7
    //    Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
    //            projects, where the second project is dependent on the first project). All of a project's dependencies
    //    must be built before the project is. Find a build order that will allow the projects to be built. If there
    //    is no valid build order, return an error.
    //    EXAMPLE
    //    Input:
    //    projects: a, b, c, d, e, f
    //    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    //    Output: f, e, a, b, d, c
    //    Hints: #26, #47, #60, #85, #125, #133
    public static <T> Deque<Graph.Node<T>> buildOrder(Graph<T> graph) {

        Map<Graph.Node<T>, List<Graph.Node<T>>> dependencies = new HashMap<>();

        for (Graph.Node<T> node : graph.nodes) {

            var arr = dependencies.get(node);
            if (arr == null) {
                arr = new ArrayList<>();
                dependencies.put(node, arr);
            }

            for (Graph.Node<T> n : node.neighbours) {
                var l = dependencies.get(n);
                if (l == null) {
                    l = new ArrayList<>();
                }
                l.add(node);
                dependencies.put(n, l);
            }

        }

        Deque<Graph.Node<T>> nodes = new ArrayDeque<>();
        for (Graph.Node<T> node : graph.nodes) {

            var list = dependencies.get(node);

            for (Graph.Node<T> n : list) {
                var addFirst = dependencies.get(n);

                for (Graph.Node<T> nn : addFirst) {
                    if (!nodes.contains(nn)) {
                        nodes.addLast(nn);
                    }
                }

                if (!nodes.contains(n)) {
                    nodes.addFirst(n);
                }
            }

            if (!nodes.contains(node)) {
                nodes.addFirst(node);
            }

        }

        return nodes;

    }
}
