package com.neetcode150.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * Shortest path algorithm for weighted graphs
 */
public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0, V);

    }
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int distance;

        public Pair(int vertex, int weight) {
            this.node = vertex;
            this.distance = weight;
        }
        @Override
        public int compareTo(Pair other) {
            return this.distance - other.distance; //ascending order
        }
    }

    //Time complexity: O(E + ElogV)
    public static void dijkstra(ArrayList<Edge> graph[], int source, int V) {
        // Initialize a priority queue to store pairs of (node, distance)
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Create a distance array to store the shortest distance from source to each vertex
        int[] distance = new int[V];

        // Initialize distances to infinity
        for (int i = 0; i < V; i++) {
            if (i != source) { // Exclude the source node from initialization
                distance[i] = Integer.MAX_VALUE;
            }
        }
        // Set the distance of the source node to 0
        boolean[] visited = new boolean[V];

        // Add the source node to the priority queue with distance 0
        pq.add(new Pair(0, 0));

        //bfs
        while (!pq.isEmpty()) {
            Pair current = pq.remove();

            if (!visited[current.node]) {
                visited[current.node] = true;

                for (int i = 0; i < graph[current.node].size(); i++) {
                    Edge edge = graph[current.node].get(i);
                    int u = edge.source;
                    int v = edge.destination;
                    int weight = edge.weight;
                    if (distance[u] + weight < distance[v]) { // Relaxation
                        distance[v] = distance[u] + weight;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        // Print the shortest distances from the source
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.print("Distance to node " + i + ": " + distance[i]);
            System.out.println();
        }
        System.out.println();

    }

}
