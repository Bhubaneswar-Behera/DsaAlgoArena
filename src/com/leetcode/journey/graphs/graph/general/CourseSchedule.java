package com.leetcode.journey.graphs.graph.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/course-schedule/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(solution.canFinish(numCourses1, prerequisites1)); // Output: true

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses2, prerequisites2)); // Output: false
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }

        // Step 2: Perform BFS (Kahn's Algorithm)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // Add courses with no prerequisites
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourses++;

            for (int neighbor : graph.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Check if all courses can be completed
        return completedCourses == numCourses;
    }
}
