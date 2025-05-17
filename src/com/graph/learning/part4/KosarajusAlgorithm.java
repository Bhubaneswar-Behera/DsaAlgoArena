package com.graph.learning.part4;



import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * For SCC (Strongly Connected Components) in directed graphs.
 */
public class KosarajusAlgorithm {
    static class Edge {
        int source;
        int destination;


        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topologicalSort(ArrayList<Edge> graph[], int current, boolean[] visited, Stack<Integer> stack) {
        visited[current] = true;
        for (int i = 0 ; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if (!visited[edge.destination]) {
                topologicalSort(graph, edge.destination, visited, stack);
            }
        }
        stack.push(current);
    }

    public static void dfs(ArrayList<Edge> graph[], int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if (!visited[edge.destination]) {
                dfs(graph, edge.destination, visited);
            }
        }
    }
    //
    public static void kosarajuAlgo(ArrayList<Edge> graph[] , int V){
        //Step 1: Topological sort  ==> Time Complexity: O(V + E)
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, visited, stack);
            }
        }

        //Step 2: Transpose the graph ==> Time Complexity: O(V + E)
        ArrayList<Edge> transposeGraph[] = new ArrayList[V];
        for (int i = 0; i < transposeGraph.length; i++) {
            //to use the same visited array
            visited[i] = false;
            transposeGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i <V ; i++) {
            for (int j = 0; j < graph[i].size() ; j++) {
                Edge edge = graph[i].get(j); //edge.source(i) --> edge.destination
                transposeGraph[edge.destination].add(new Edge(edge.destination, edge.source)); //edge.destination --> edge.source
            }
        }

        //Step 3: DFS on the transposed graph ==> Time Complexity: O(V + E)
        while (!stack.isEmpty()) {
        int current = stack.pop();
            if (!visited[current]) {
                dfs(transposeGraph, current, visited);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("The strongly connected components are: ");
        kosarajuAlgo(graph, V);

    }

}
