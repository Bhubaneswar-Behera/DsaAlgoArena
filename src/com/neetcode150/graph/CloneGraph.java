package com.neetcode150.graph;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/clone-graph/description/
 * Reference : https://www.youtube.com/watch?v=c9Myn-zYmJs&t=24928s
 */
public class CloneGraph {

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
