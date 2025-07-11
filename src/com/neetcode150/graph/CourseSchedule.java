package com.neetcode150.graph;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/course-schedule/description/
 * Reference : https://www.youtube.com/watch?v=c9Myn-zYmJs
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        CourseSchedule courseSchedule = new CourseSchedule();
        boolean canFinish = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }
    public  boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> courseGraph = new HashMap<>();

        // Build the graph from prerequisites
        for(int[] pre: prerequisites){
            //For each pair, the code
            // checks if b (the prerequisite course) is already a key in the courseGraph.
            if(courseGraph.containsKey(pre[1])){
                courseGraph.get(pre[1]).add(pre[0]);
            }
            else{
                //If b is not a key, it creates a new list (nextCourses),
                // adds a to it, and then puts this list into the courseGraph with b as the key.
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(pre[0]);
                courseGraph.put(pre[1],nextCourses);
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        for(int currentCourse = 0; currentCourse<numCourses; currentCourse++ ){
            if(dfs(currentCourse,visited,courseGraph) == false){
                return false;
            }
        }
        return true;

    }

    public boolean dfs (int course, HashSet<Integer> visited,
                                   HashMap<Integer, List<Integer>> courseGraph){
        // If the course is already in the visited set,
        if(visited.contains(course)){
            return false;
        }
        // If the course has no prerequisites (i.e., it is not in the courseGraph),
        if(courseGraph.get(course) == null){
            return true;
        }

        // Mark the course as visited
        visited.add(course);
        // Recursively visit all the prerequisites of the course
        for(int pre: courseGraph.get(course)){
            // If any prerequisite cannot be completed (i.e., returns false),
            if(dfs(pre, visited,courseGraph ) == false){
                return false;
            }
        }
        // After exploring all prerequisites for the course,
        visited.remove(course);
        // it is safe to mark it as completed by removing it from the courseGraph.
        courseGraph.put(course,null);
        return true;

    }
}
