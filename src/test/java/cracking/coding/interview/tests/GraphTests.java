package cracking.coding.interview.tests;

import cracking.coding.interview.datastructures.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

class GraphTests {

    @Test
    void givenInsertAdjacentNode_ThenShouldBuildDirectedGraph() {
        var n1 = new Graph.Node<>(1);
        var n2 = new Graph.Node<>(2);
        var n3 = new Graph.Node<>(3);
        var n4 = new Graph.Node<>(4);

        n1.addNeighbour(n3);
        n1.addNeighbour(n2);
        n2.addNeighbour(n3);
        n3.addNeighbour(n1);
        n4.addNeighbour(n2);

        List<Graph.Node<Integer>> nodes = Arrays.asList(n1, n2, n3, n4);

        Graph<Integer> graph = new Graph<>(nodes);

        Assertions.assertEquals(2, graph.breadthFirstSearch(2).data);
        Assertions.assertEquals(1, graph.breadthFirstSearch(1).data);
        Assertions.assertEquals(3, graph.breadthFirstSearch(3).data);
        Assertions.assertNull(graph.breadthFirstSearch(4));

    }


    @Test
    void givenFindAPathBetweenTwoNodesInADirectedGraph_WhenTheGraphIsOk_ThenShouldFindThePathAndReturnIt() {
        Graph.Node<Integer> n1 = new Graph.Node<>(1);
        Graph.Node<Integer> n2 = new Graph.Node<>(2);
        Graph.Node<Integer> n3 = new Graph.Node<>(3);
        Graph.Node<Integer> n4 = new Graph.Node<>(4);
        Graph.Node<Integer> n5 = new Graph.Node<>(5);
        Graph.Node<Integer> n6 = new Graph.Node<>(6);
        Graph.Node<Integer> n7 = new Graph.Node<>(7);
        Graph.Node<Integer> n8 = new Graph.Node<>(8);

        n1.addNeighbour(n2);
        n1.addNeighbour(n3);
        n1.addNeighbour(n5);

        n2.addNeighbour(n1);
        n2.addNeighbour(n6);

        n3.addNeighbour(n4);

        n4.addNeighbour(n7);

        n5.addNeighbour(n2);

        n6.addNeighbour(n2);

        n7.addNeighbour(n3);
        n7.addNeighbour(n8);

        n8.addNeighbour(n7);

        Graph<Integer> graph = new Graph<>(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8));

        Assertions.assertEquals(Arrays.asList(n6, n2, n1, n3, n4, n7, n8), graph.findRouteBetweenTwoNodes(n6, n8));

    }


    @Test
    void givenFindAPathBetweenTwoNodesInADirectedGraph_WhenTheGraphIsBiggerAndStillIsOk_ThenShouldFindThePathAndReturnIt() {
        Graph.Node<Integer> n1 = new Graph.Node<>(1);
        Graph.Node<Integer> n2 = new Graph.Node<>(2);
        Graph.Node<Integer> n3 = new Graph.Node<>(3);
        Graph.Node<Integer> n4 = new Graph.Node<>(4);
        Graph.Node<Integer> n5 = new Graph.Node<>(5);
        Graph.Node<Integer> n6 = new Graph.Node<>(6);
        Graph.Node<Integer> n7 = new Graph.Node<>(7);
        Graph.Node<Integer> n8 = new Graph.Node<>(8);
        Graph.Node<Integer> n9 = new Graph.Node<>(9);
        Graph.Node<Integer> n10 = new Graph.Node<>(10);
        Graph.Node<Integer> n11 = new Graph.Node<>(11);
        Graph.Node<Integer> n12 = new Graph.Node<>(12);
        Graph.Node<Integer> n13 = new Graph.Node<>(13);
        Graph.Node<Integer> n14 = new Graph.Node<>(14);

        n1.addNeighbour(n2);
        n1.addNeighbour(n3);
        n1.addNeighbour(n5);

        n2.addNeighbour(n1);
        n2.addNeighbour(n6);

        n3.addNeighbour(n4);

        n4.addNeighbour(n7);

        n5.addNeighbour(n2);
        n5.addNeighbour(n11);

        n6.addNeighbour(n2);

        n7.addNeighbour(n3);
        n7.addNeighbour(n8);

        n8.addNeighbour(n7);

        n11.addNeighbour(n5);
        n11.addNeighbour(n10);

        n10.addNeighbour(n13);

        n12.addNeighbour(n10);

        n13.addNeighbour(n10);
        n13.addNeighbour(n9);

        Graph<Integer> graph = new Graph<>(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13));
        Assertions.assertEquals(Arrays.asList(n6, n2, n1, n3, n4, n7, n8), graph.findRouteBetweenTwoNodes(n6, n8));
    }

    @Test
    void givenBuildOrder_WhenItsPossibleToGetTheRightBuildOrder_ThenShouldReturnADeque() {
        //    projects: a, b, c, d, e, f
        Graph.Node<String> a = new Graph.Node<>("A");
        Graph.Node<String> b = new Graph.Node<>("B");
        Graph.Node<String> c = new Graph.Node<>("C");
        Graph.Node<String> d = new Graph.Node<>("D");
        Graph.Node<String> e = new Graph.Node<>("E");
        Graph.Node<String> f = new Graph.Node<>("F");

        //    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
        a.addNeighbour(f);
        b.addNeighbour(f);
        c.addNeighbour(d);
        d.addNeighbour(a);
        d.addNeighbour(b);

        //    Output: f, e, a, b, d, c || f, e, b, a, d, c (depends on graph order).
        Graph<String> graph = new Graph<>(Arrays.asList(a, b, c, d, e, f));

        Graphs.buildOrder(graph);

        var result = Graphs.buildOrder(graph);
        var resultAsList = result.stream().toList();

        Assertions.assertEquals(f, resultAsList.get(0));
        Assertions.assertEquals(e, resultAsList.get(1));

        try {
            Assertions.assertEquals(a, resultAsList.get(2));
            Assertions.assertEquals(b, resultAsList.get(3));
        } catch (AssertionFailedError ex) {
            Assertions.assertEquals(b, resultAsList.get(2));
            Assertions.assertEquals(a, resultAsList.get(3));
        }

        Assertions.assertEquals(d, resultAsList.get(4));
        Assertions.assertEquals(c, resultAsList.get(5));
    }
}
