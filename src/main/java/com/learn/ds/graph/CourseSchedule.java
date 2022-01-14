package com.learn.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private boolean[] visited;
    private boolean[] marked;

    public  boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adj matrix
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prereq = prerequisites[i];
            if (!adj.containsKey(prereq[0])) {
                adj.put(prereq[0], new ArrayList<>());
            }
            adj.get(prereq[0]).add(prereq[1]);
        }

        visited = new boolean[numCourses];
        marked = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) continue;
            if (isCyclic(i)) return false;
        }
        return true;
    }

    private boolean isCyclic (int vertex) {
        if (visited[vertex] && !marked[vertex]) return true;
        if (visited[vertex] && marked[vertex]) return false;
        if (!adj.containsKey(vertex)) return false;

        visited[vertex] = true;
        List<Integer> list = adj.get(vertex);
        for (int i = 0; i < list.size(); i++) {
            if (isCyclic(list.get(i))) return true;
        }
        marked[vertex] = true;
        return false;
    }

    public static void main (String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        //System.out.println(canFinish(2, new int[][] { {1, 0} }));
        System.out.println(courseSchedule.canFinish(2, new int[][] { {0, 1} }));
        //System.out.println(canFinish(2, new int[][] { {1, 0}, {0, 1} }));
    }
}
