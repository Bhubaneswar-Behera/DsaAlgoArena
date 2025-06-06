package com.graph.learning.part2;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Create a graph with V vertices and the given edges
        for (int i = 0; i < graph.length ; i++) {
                graph[i] = new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSortUtil(ArrayList<Edge> graph[],int current, boolean visited[], Stack<Integer> stack) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size() ; i++) {
            Edge edge = graph[current].get(i);
            if(!visited[edge.dest]){
                topSortUtil(graph,edge.dest,visited,stack);
            }
        }
        stack.push(current);
    }
    public static void topSort(ArrayList<Edge> graph[], int V) {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V ; i++) {
            if(!visited[i]){
                topSortUtil(graph,i,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
       topSort(graph,V);
    }
}
