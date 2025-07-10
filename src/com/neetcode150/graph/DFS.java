package com.neetcode150.graph;

import java.util.ArrayList;

public class DFS {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void dfs(ArrayList<Edge> graph[], int current, boolean[] visited) {
        // Print the current node
        System.out.print(current + " ");
        // Mark the current node as visited
        visited[current] = true;

        // Traverse all the edges of the current node
        for (int i = 0; i < graph[current].size(); i++) {
            // Get the edge from the current node
            Edge edge = graph[current].get(i);
            // If the destination of the edge is not visited, perform DFS on it
            if (visited[edge.dest] == false) {
                // Recursive call to DFS for the destination node
                dfs(graph, edge.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7; // Number of vertices

        /*
        1 -- 3
       /     |  \
      0      |   5 -- 6
       \     |  /
        2 -- 4
        */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];
        dfs(graph, 0, visited);
    }
}
