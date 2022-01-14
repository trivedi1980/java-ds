package com.learn.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelay {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<String, Integer> edgeTime = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(time[1]);
            edgeTime.put(time[0] + "-" + time[1], time[2]);
        }
        boolean[] visited = new boolean[n+1];

        int time = maxDfs(k, adj, edgeTime, visited);
        for (int i = 1; i <=n; i++) {
            if (!visited[i]) return -1;
        }
        return time;
    }

    private static int maxDfs(int node, Map<Integer, List<Integer>> adj,
                       Map<String, Integer> edgeTime,
                       boolean[] visited) {
        if (adj.get(node).isEmpty()) {
            visited[node] = true;
            return 0;
        }
        if (visited[node]) return -1;

        List<Integer> adjList = adj.get(node);
        visited[node] = true;
        int time = Integer.MIN_VALUE;
        for (int i = 0; i < adjList.size(); i++) {
            time = Math.max(time, edgeTime.get(node + "-" + adjList.get(i))
                    + maxDfs(adjList.get(i), adj, edgeTime, visited));
        }
        return time;
    }

    public static void main(String[] args) {
        // [[2,1,1],[2,3,1],[3,4,1]]
        // 4
        // 2

        //[[1,2,1],[2,3,2],[1,3,2]]
        //3
        //1


        System.out.println(networkDelayTime(new int[][] {
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 2}
        }, 3, 1));
    }
}
