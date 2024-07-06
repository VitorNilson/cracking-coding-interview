package cracking.coding.interview.datastructures;

import java.util.*;
import java.util.Queue;

public class Graph<T> {
    public List<Node<T>> nodes = new ArrayList<>();

    public Graph(List<Node<T>> nodes) {
        this.nodes = nodes;
    }

    public static class Node<T> {
        public T data;
        public List<Node<T>> neighbours = new ArrayList<>();

        public Node(T data) {
            this.data = data;
        }

        public void addNeighbour(Node<T> neighbour) {
            neighbours.add(neighbour);
        }
    }

    // This is a simple implementation of BFS. This simple implementation will not find disconnected (unreachable) nodes.
    public Node<T> breadthFirstSearch(T value) {
        return breadthFirstSearch(nodes.get(0), value);
    }

    public Node<T> breadthFirstSearch(Node<T> root, T value) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Node<T>> markedNodes = new HashSet<>();
        markedNodes.add(root);
        System.out.println("Searching for: " + value);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            if (node.data.equals(value)) {
                System.out.println("Found at Node: " + node + "\n\n");
                return node;
            }

            for (Node<T> n : node.neighbours) {

                if (!markedNodes.contains(n)) {
                    markedNodes.add(n);
                    System.out.print(n.data + " -> ");
                    if (n.data.equals(value)) {
                        System.out.println("Found at Node: " + node + "\n\n");
                        return n;
                    }
                    queue.add(n);
                }
            }
        }
        System.out.println("\n\n");
        return null;
    }


    // This implementation is for DIRECTED Graphs.
    public List<Node<T>> findRouteBetweenTwoNodes(Node<T> nodeA, Node<T> nodeB) {
        Queue<Node<T>> queueA = new ArrayDeque<>();
        Queue<Node<T>> queueB = new ArrayDeque<>();

        queueA.add(nodeA);
        queueB.add(nodeB);

        Deque<Node<T>> markedNodesA = new ArrayDeque<>();
        Deque<Node<T>> markedNodesB = new ArrayDeque<>();

        markedNodesA.add(nodeA);
        markedNodesB.add(nodeB);

        Node<T> intersectNode = null;
        outer:
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            Node<T> tempA = queueA.poll();
            Node<T> tempB = queueB.poll();

            if (tempA != null) {
                for (Node<T> n : tempA.neighbours) {
                    if (!markedNodesA.contains(n)) {
                        markedNodesA.add(n);
                        queueA.add(n);
                        if (markedNodesB.contains(n)) {
                            intersectNode = n;
                            break outer;
                        }
                    }
                }
            }


            if (tempB != null) {
                for (Node<T> n : tempB.neighbours) {
                    if (!markedNodesB.contains(n) && n.neighbours.contains(tempB)) {
                        markedNodesB.push(n);
                        queueB.add(n);
                        if (markedNodesA.contains(n)) {
                            intersectNode = n;
                            break outer;
                        }
                    }
                }
            }

            if (intersectNode != null) {
                break;
            }
        }

        if (intersectNode == null) {
            return null;
        }

        // the last is equal to first of markedNodesB
        markedNodesA.removeLast();
        markedNodesA.addAll(markedNodesB);

        List<Node<T>> nodes = markedNodesA.stream().toList();
        List<Node<T>> result = new ArrayList<>();
        result.add(nodes.get(0));

        int ctrl = 1;
        for (int i = 1; i < nodes.size() ; i++) {

            if(result.get(ctrl -1).neighbours.contains(nodes.get(i))) {
                result.add(nodes.get(i));
                ctrl++;
            }
        }


        return result;
    }
}
