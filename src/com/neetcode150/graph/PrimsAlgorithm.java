 package com.neetcode150.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        //graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int vertex, int cost) {
            this.node = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair other) {
            return this.cost - other.cost; //ascending order
        }
    }

    //Time complexity: O(ElogE)
    public static void primsAlgorithm(ArrayList<Edge> graph[] , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //non-mst set
        boolean[] visited = new boolean[V];//mst set
        int mstCost = 0;
        pq.add(new Pair(0,0));

        // while the priority queue is not empty
        while (!pq.isEmpty()) {
            //get the minimum cost edge from the priority queue
            Pair current = pq.remove();
            //if the current node is not visited, add it to the mst set
            if (!visited[current.node]) {
                //mark the current node as visited
                visited[current.node] = true;
                //add the cost of the current edge to the mst cost
                mstCost += current.cost;

                //print the current edge
                for (int i = 0 ;  i < graph[current.node].size() ;i ++) {
                    //get the edge from the graph
                    Edge edge = graph[current.node].get(i);

                    //if the edge is not in the mst set
                    if (!visited[edge.destination]) {
                        //add the edge to the priority queue
                        pq.add(new Pair(edge.destination, edge.weight));
                    }
                }
            }
        }
        System.out.println("Minimum Spanning Tree Cost: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primsAlgorithm(graph, V);
    }
}
