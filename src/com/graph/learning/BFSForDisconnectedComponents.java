package com.graph.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSForDisconnectedComponents {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V ,boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (visited[current] == false) {
                System.out.print(current + " ");
                visited[current] = true;
                for (int i = 0; i < graph[current].size(); i++) {
                    Edge edge = graph[current].get(i);
                    queue.add(edge.dest);
                }
            }
        }
    }
    //Time complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
    public static void main(String[] args) {
        int V = 7;

       /*
        1 -- 3
       /     |  \
      0      |   5 -- 6
       \     |  /
        2 -- 4
        */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                bfs(graph, V ,visited, i);
            }
        }
        System.out.println();
    }
}
