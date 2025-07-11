package com.neetcode150.graph;

import java.util.ArrayList;

/**
 *
 * source = 0, target = 5
 */
public class AllPathsFromSourceToTarget {

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
        graph[0].add(new  Edge(0, 1));
        graph[0].add(new  Edge(0, 2));

        graph[1].add(new  Edge(1, 0));
        graph[1].add(new  Edge(1, 3));

        graph[2].add(new  Edge(2, 0));
        graph[2].add(new  Edge(2, 4));

        graph[3].add(new  Edge(3, 1));
        graph[3].add(new  Edge(3, 4));
        graph[3].add(new  Edge(3, 5));

        graph[4].add(new  Edge(4, 2));
        graph[4].add(new  Edge(4, 3));
        graph[4].add(new  Edge(4, 5));

        graph[5].add(new  Edge(5,3));
        graph[5].add(new  Edge(5,4));
        graph[5].add(new  Edge(5,6));

        graph[6].add(new  Edge(6,5));
    }

    /**
     * Time Complexity: O(V^V)
     */
    public static void printAllPaths(ArrayList<Edge> graph[],boolean[] visited, int current,String path ,int target) {
      if (current == target) {
          System.out.println(path);
          return;
      }
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if(!visited[edge.dest]){
                visited[current] = true;
                printAllPaths(graph, visited, edge.dest, path+edge.dest , target);
                visited[current] = false;
            }
        }

    }

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

        int source = 0;
        int target = 5;
        boolean[] visited = new boolean[V];
        printAllPaths(graph, visited, source, "0", target);
    }
}
