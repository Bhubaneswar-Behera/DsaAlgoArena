package com.neetcode150.graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Topological Sort using Depth First Search (DFS)
 * Example:
 *  For a directed acyclic graph (DAG) with V vertices,
 *  we can represent the graph using an adjacency list of size V x V.
 *  N = 6
 *  Edges = [[2, 3], [3, 1], [4, 0], [4, 1], [5, 0], [5, 2]]
 *  Output: 5 4 2 3 1 0
 *
 *
 */
public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph,V);
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Create a graph with V vertices and the given edges
        for (int i = 0; i < graph.length ; i++) {
                graph[i] = new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge> graph[], int V) {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V ; i++) {
            // For each vertex, check if it is visited
            if(!visited[i]){
                // If not visited, perform DFS on that vertex
                dfs(graph,i,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void dfs(ArrayList<Edge> graph[],int current, boolean visited[], Stack<Integer> stack) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size() ; i++) {
            // For each edge, check if the destination is visited
            Edge edge = graph[current].get(i);
            // If not visited, perform DFS on that edge
            if(!visited[edge.destination]){
                // Recursive call to dfs
                dfs(graph,edge.destination,visited,stack);
            }
        }
        stack.push(current);
    }


}
