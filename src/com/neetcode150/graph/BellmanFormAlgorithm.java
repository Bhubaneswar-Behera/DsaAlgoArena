 package com.neetcode150.graph;

import java.util.ArrayList;

public class BellmanFormAlgorithm {
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
        graph[0].add( new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }
    //Time Complexity: O(V * E)
     public static void bellmanFord(ArrayList<Edge> graph[], int source, int V) {
         int[] distance = new int[V];
         for (int i = 0; i < V; i++) {
             if(i != source) {
                 distance[i] = Integer.MAX_VALUE;
             }
         }
         // Initialize the distance to the source node
         distance[source] = 0;

         //Toatal  Time complexity: O(V*E)
         for (int k = 0; k < V ; k++) { //Time complexity: O(V)
             //Time complexity: O(E)
             for (int i = 0; i < V ; i++) {
                 for (int j = 0; j < graph[i].size() ; j++) {
                     Edge edge = graph[i].get(j);
                     int u = edge.source;
                     int v = edge.destination;
                     // Relaxation step
                     // If the distance to the source node is not infinite and the distance to the destination node can be improved
                     // update the distance to the destination node
                     // distance[v] = Math.min(distance[v], distance[u] + edge.weight);
                     int weight = edge.weight;
                        if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                            distance[v] = distance[u] + weight;
                        }
                 }
             }
         }


         // Print the shortest distances
         System.out.println("Vertex Distance from Source");
         for (int i = 0; i < distance.length; i++) {
             System.out.print( distance[i] +" ");
         }
         System.out.println();
     }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFord(graph,0, V);
    }
}
