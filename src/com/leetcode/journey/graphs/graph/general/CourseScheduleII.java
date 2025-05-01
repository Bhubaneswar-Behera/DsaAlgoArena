package com.leetcode.journey.graphs.graph.general;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/course-schedule-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses1, prerequisites1))); // Output: [0, 1]

        // Example 2
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses2, prerequisites2))); // Output: [0, 1, 2, 3] or other valid orders
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order[index++] = currentCourse;

            for (int neighbor : graph.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Check if all courses can be completed
        if (index == numCourses) {
            return order;
        } else {
            return new int[0]; // Return an empty array if it's impossible
        }
    }

}
