package com.neetcode150.graph;

import java.util.ArrayList;

/**
 *
 * Bridge in Graph using Tarjan's Algorithm
 */
public class BridgeInGraphUsingTarjansAlgorithm {

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Bridges in the given graph:");
        getBridge(graph, V);
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
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
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    //Time Complexity: O(V + E)
    public static void getBridge(ArrayList<Edge> graph[],int V){
        // Initialize discovery time
        int[] discoveryTime = new int[V];
        // Initialize lowest discovery time
        int[] lowestDiscovery = new int[V];
        // Initialize time
        int time = 0;
        // Initialize visited array
        boolean[] visited = new boolean[V];

        // Perform DFS for each unvisited vertex
        for (int i = 0; i < V; i++) {
            // If the vertex is not visited, call DFS
            if (!visited[i]) {
                // Call DFS for the current vertex
                dfs(graph, i, visited, discoveryTime, lowestDiscovery, time, -1);
            }
        }

    }

    public static void dfs(ArrayList<Edge> graph[], int current, boolean[] visited,
                           int[] discoveryTime, int[] lowestDiscoveryTime, int time, int parent) {
        // Mark the current node as visited
        visited[current] = true;
        // Initialize discovery time and lowest discovery time
        // why we are using ++time here?
        // Because we want to assign the discovery time in increasing order
        discoveryTime[current] = lowestDiscoveryTime[current] = ++time;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            // If the destination is the parent, skip it
            if(edge.destination == parent) {
                continue;
            }
            // If the destination is not visited, perform DFS on it
            else if (!visited[edge.destination]) {
                // Recur for the destination vertex
                dfs(graph, edge.destination, visited, discoveryTime, lowestDiscoveryTime, time, current);
                // Update the lowest discovery time for the current vertex
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], lowestDiscoveryTime[edge.destination]);

                if (discoveryTime[current] < lowestDiscoveryTime[edge.destination]) {
                    System.out.println("Bridge is: " + current + " --> " + edge.destination);
                }
            }
            // If the destination is already visited and is not the parent, update the lowest discovery time
            // why discoveryTime[edge.destination] is used here?
            // Because we want to find the lowest discovery time of the current vertex : Articulation Point
            else if (edge.destination != parent) {
                lowestDiscoveryTime[current] = Math.min(lowestDiscoveryTime[current], discoveryTime[edge.destination]);
            }
        }
    }


}
