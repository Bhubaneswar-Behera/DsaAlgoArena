package com.neetcode150.graph;

import java.util.ArrayList;

public class UnDirectedCycleDetection {

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Graph contains cycle: " + isCycleUndirected(graph, new boolean[V], 0, -1));
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        //comment the below line to remove cycle
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        //comment the below line to remove cycle
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean visited[], int current, int parent) {
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            // If the destination is already visited and is not the parent, a cycle is detected
            if (visited[edge.destination] && edge.destination != parent) {
                return true;
            }
            // If the destination is not visited, continue DFS
            else if (!visited[edge.destination]) {
                if(isCycleUndirected(graph, visited, edge.destination, current)){
                    return true;
                }
            }
        }
        return false;
    }

}
