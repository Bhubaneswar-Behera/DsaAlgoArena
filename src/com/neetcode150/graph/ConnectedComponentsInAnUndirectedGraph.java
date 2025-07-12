package com.neetcode150.graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://neetcode.io/problems/count-connected-components?list=neetcode150
 * Reference : https://www.youtube.com/watch?v=c9Myn-zYmJs
 */
public class ConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 4}};
        ConnectedComponentsInAnUndirectedGraph graph = new ConnectedComponentsInAnUndirectedGraph();
        int result = graph.countComponents(n, edges);
        System.out.println("Number of connected components: " + result);
    }
    public int countComponents(int n, int[][] edges) {

        int counter = 0;
        int[] visited = new int[n];
        // Initialize adjacency list
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        // Build the adjacency list from edges
        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        // Iterate through each node
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                counter++;
                dfs(adjList,visited, i);
            }
        }

        return counter;
    }
    // Depth First Search (DFS) to visit all nodes in a component
    public void dfs(List<Integer>[] adjList, int[] visited, int node){
        // Mark the current node as visited
        visited[node] = 1;
        // Visit all adjacent nodes
        for(int i=0; i<adjList[node].size(); i++){
            // If the adjacent node is not visited, perform DFS on it
            if(visited[adjList[node].get(i)] == 0){
                // Recursive call to visit the adjacent node
                dfs(adjList, visited, adjList[node].get(i));
            }
        }
    }
}
