package com.neetcode150.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/valid-tree?list=neetcode150
 * Reference : https://www.youtube.com/watch?v=WU3-vo0MJW0
 */
public class GraphValidTree {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(isValidTree(n, edges)); // Output: true

        n = 5;
        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(isValidTree(n, edges)); // Output: false
    }
    public static boolean isValidTree(int n, int[][] edges) {
        // A valid tree must have exactly n-1 edges
        if (edges.length != n-1){
            return false;
        }
        // Create an adjacency list to represent the graph
        List<List<Integer>> adjancencyList = new ArrayList();
        for(int i=0; i<n; i++){
            adjancencyList.add(new ArrayList<>());
        }
        // Populate the adjacency list with edges
        for(int[] edge:edges){
            adjancencyList.get(edge[0]).add(edge[1]);
            adjancencyList.get(edge[1]).add(edge[0]);
        }
        // Use a stack to perform DFS
        Stack<Integer> stack = new Stack<>();
        // Use a set to keep track of visited nodes
        HashSet<Integer> visited = new HashSet<>();

        // Start DFS from node 0
        stack.push(0);
        // Mark node 0 as visited
        visited.add(0);

        // Perform DFS
        while(!stack.isEmpty()){
            int node = stack.pop();
            // Iterate through all the neighbours of the current node
            for(int neighbour:adjancencyList.get(node)){
                // If the neighbour is already visited, skip it
                if(visited.contains(neighbour)){
                    continue;
                }
            // If the neighbour is not visited, mark it as visited and push it onto the stack
                visited.add(neighbour);
                // Push the neighbour onto the stack for further exploration
                stack.push(neighbour);
            }
        }

        // After DFS, check if all nodes are visited
        if(visited.size() == n){
            return true;
        }
        return false;
    }

}
