package com.neetcode150.graph;

import java.util.ArrayList;

/**
 *
 * Articulation Point in Graph using Tarjan's Algorithm
 */
public class ArticulationPointInGraph {

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        ArticulationPointInGraph apg = new ArticulationPointInGraph();
        apg.createGraph(graph);
        apg.getArticulationPoints(graph, V);
    }
    public void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // Time Complexity: O(V + E)
    public void getArticulationPoints(ArrayList<Edge> graph[], int V) {
        // Initialize discovery time
        int[] discoveryTime = new int[V];

        // Initialize lowest discovery time
        int[] lowestDiscovery = new int[V];

        // Initialize time
        int time = 0;

        // Initialize visited array
        boolean[] visited = new boolean[V];

        // Initialize articulation points array
        boolean[] articulationPoints = new boolean[V];

        // Perform DFS for each unvisited vertex
        for (int i = 0; i < V; i++) {
            // If the vertex is not visited, call DFS
            if (!visited[i]) {
                // Call DFS for the current vertex
                dfs(graph, i, -1, discoveryTime, lowestDiscovery, visited, time, articulationPoints);
            }
        }

        // Print articulation points
        System.out.println("Articulation Points in the given graph:");
        for (int i = 0; i < V; i++) {
            if (articulationPoints[i]) { //
                System.out.print(i + " ");
            }
        }
    }
    public void dfs(ArrayList<Edge> graph[], int current, int parent,int[] discoveryTime,
                    int[] lowestDiscoveryTime, boolean[] visited, int time,  boolean[] articulationPoints) {
        // Mark the current node as visited
        visited[current] = true;

        // Set discovery time and lowest discovery time
        discoveryTime[current] = lowestDiscoveryTime[current] = ++time;

        // Initialize children count
        int children = 0;

        // Iterate through all adjacent vertices
        for (int i = 0; i < graph[current].size() ; i++) {
            Edge edge = graph[current].get(i);
            int neighbor = edge.destination;

            // If the neighbor is the parent, skip it
            if (parent == neighbor) {
                continue;
            }
            // if the neighbor is already visited
            else if (visited[neighbor]) {
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], discoveryTime[neighbor]);
            }
            // If the neighbor is not visited, perform DFS on it
            else {
                dfs(graph, neighbor, current, discoveryTime, lowestDiscoveryTime, visited, time, articulationPoints);
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], lowestDiscoveryTime[neighbor]);
                // discovery time of the current node is less than or equal to the lowest discovery time of the neighbor
                // and the parent is not -1 (i.e., current is not the root node)
                if (discoveryTime[current] <= lowestDiscoveryTime[neighbor] && parent != -1) {
                    articulationPoints[current] = true;
                }
                children++;
            }
        }
        // If the current node is the root and has more than one child, it is an articulation point
        if (parent == -1 && children > 1) {
            articulationPoints[current] = true;
        }
    }

}
