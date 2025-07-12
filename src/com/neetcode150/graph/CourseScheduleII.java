package com.neetcode150.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] order = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println("Course order: " + java.util.Arrays.toString(order));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Track in-degree (number of prerequisites) for each course
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course); // prerequisite → course
            inDegree[course]++; // Increase in-degree of course because it has a prerequisite
        }

        // Step 3: Use a queue to start with courses having no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i); // Course with no prerequisite
            }
        }

        // Step 4: Process nodes (courses) in BFS manner
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current; // Add course to the final order

            // Reduce in-degree of neighbors (dependent courses)
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor); // If in-degree becomes 0, it means all prerequisites are done --> add to queue
                }
            }
        }

        // Step 5: Check if all courses are processed
        if (index == numCourses) {
            return order; // Valid topological order
        }

        return new int[0]; // Cycle detected, return empty array
    }

}
