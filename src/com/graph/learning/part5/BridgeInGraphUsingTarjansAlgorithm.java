package com.graph.learning.part5;

import java.util.ArrayList;

/**
 *
 * Bridge in Graph using Tarjan's Algorithm
 */
public class BridgeInGraphUsingTarjansAlgorithm {

    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
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

    public static void getBridge(ArrayList<Edge> graph[],int V){
        int[] discoveryTime = new int[V];
        int[] lowestDiscovery = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, discoveryTime, lowestDiscovery, time, -1);
            }
        }

    }

    public static void dfs(ArrayList<Edge> graph[], int current, boolean[] visited,
                           int[] discoveryTime, int[] lowestDiscovery, int time, int parent) {
        visited[current] = true;
        discoveryTime[current] = lowestDiscovery[current] = ++time;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(edge.dest == parent) {
                continue;
            }
            else if (!visited[edge.dest]) {
                dfs(graph, edge.dest, visited, discoveryTime, lowestDiscovery, time, current);
                lowestDiscovery[current] = Math.min(lowestDiscovery[current], lowestDiscovery[edge.dest]);

                if (discoveryTime[current] < lowestDiscovery[edge.dest]) {
                    System.out.println("Bridge is: " + current + " --> " + edge.dest);
                }
            } else if (edge.dest != parent) {
                lowestDiscovery[current] = Math.min(lowestDiscovery[current], discoveryTime[edge.dest]);
            }
        }
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Bridges in the given graph:");
        getBridge(graph, V);
    }
}
