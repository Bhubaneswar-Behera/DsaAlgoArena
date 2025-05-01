package com.leetcode.journey.graphs.graph.general;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class EvaluateDivision {

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();

        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results)); // Output: [6.0, 0.5, -1.0, 1.0, -1.0]
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        // Step 2: Evaluate each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);

            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                results[i] = -1.0; // If either variable is not in the graph
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, c, d, 1.0, visited);
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double product, Set<String> visited) {
        if (current.equals(target)) {
            return product; // Found the target
        }

        visited.add(current);

        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), target, product * neighbor.getValue(), visited);
                if (result != -1.0) {
                    return result; // Found a valid path
                }
            }
        }

        return -1.0; // No valid path found
    }
}
