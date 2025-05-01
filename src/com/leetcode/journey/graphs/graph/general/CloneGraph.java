package com.leetcode.journey.graphs.graph.general;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/clone-graph/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class CloneGraph {

    public static void main(String[] args) {
        // Create a sample graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph solution = new CloneGraph();
        Node clonedGraph = solution.cloneGraph(node1);

        // Print the cloned graph (for verification)
        System.out.println("Cloned Node 1 Neighbors: " + clonedGraph.neighbors.size());
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Map to store the original node to its clone
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        // If the node is already cloned, return the clone
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Clone the node
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Clone all the neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }

        return clone;
    }
}
