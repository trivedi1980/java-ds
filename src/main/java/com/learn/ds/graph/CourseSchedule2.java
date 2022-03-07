package com.learn.ds.graph;

import java.util.*;

public class CourseSchedule2 {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] each: prerequisites) {
            adjList.get(each[0]).add(each[1]);
        }

        int[] result = new int[0];
        for (int i = 0; i < numCourses; i++) {
            List<Integer> courseList = new ArrayList<>();
            if (dfs(i, courseList, new HashSet<>(), new HashSet<>()) && courseList.size() == numCourses) {
                result = new int[courseList.size()];
                for (int j = 0; j < courseList.size(); j++) {
                    result[j] = courseList.get(j);
                }
                break;
            }
        }
        return result;
    }

    private boolean dfs(int c, List<Integer> courseList, Set<Integer> visited, Set<Integer> completed) {
        if (visited.contains(c) && !completed.contains(c)) return false;
        if (visited.contains(c) && completed.contains(c)) return true;

        if (adjList.get(c).size() == 0) {
            visited.add(c);
            completed.add(c);
            courseList.add(c);
            return true;
        }

        visited.add(c);
        for (int each : adjList.get(c)) {
            if (!dfs(each, courseList, visited, completed)) return false;
        }
        courseList.add(c);
        completed.add(c);
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule2 ref = new CourseSchedule2();
        System.out.println(Arrays.toString(ref.findOrder(2, new int[][] {
        })));
    }
}
