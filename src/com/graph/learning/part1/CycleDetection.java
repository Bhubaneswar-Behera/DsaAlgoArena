package com.graph.learning.part1;

import java.util.ArrayList;

public class CycleDetection {

    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
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

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visited[], int current ,boolean recStack[]) {
        visited[current] = true;
        recStack[current] = true;

        for (int i = 0; i < graph[current].size() ; i++) {
            Edge edge = graph[current].get(i);
            if(recStack[edge.dest]){ //cycle detected
                return true;
            }
            else if(!visited[edge.dest] && isCycleDirected(graph, visited, edge.dest, recStack)){
                    return true;
                }
        }
        recStack[current] = false; //backtrack
        return false;
    }
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
}
