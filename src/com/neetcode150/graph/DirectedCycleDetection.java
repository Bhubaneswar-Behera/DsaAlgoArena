package com.neetcode150.graph;

import java.util.ArrayList;

public class DirectedCycleDetection {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean isCycleDetected = isCycleDirected(graph, visited, 0, recStack); // Output: true
                if(isCycleDetected){
                    System.out.println("Cycle detected");
                    break;
                }
            }
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2,3));

        //comment the below line to remove cycle
        graph[3].add(new Edge(3,0));

    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visited[], int current ,boolean recursionStack[]) {
        visited[current] = true;
        recursionStack[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            // If the destination is already in the recursion stack, a cycle is detected
            if (recursionStack[edge.destination]) { // cycle detected
                return true;
            }
            // If the destination is not visited, continue DFS
            if (!visited[edge.destination]) {
                if (isCycleDirected(graph, visited, edge.destination, recursionStack)) {
                    return true;
                }
            }
        }
        recursionStack[current] = false; // backtrack
        return false;
    }

}
