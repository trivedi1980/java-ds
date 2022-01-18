package com.learn.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestComponent {
    public static void main(String[] args) {
        System.out.println(largestComponent(9, new int[][] {
                {1, 0}, {0, 8}, {0, 5}, {5, 8}, {4, 3}, {4, 2}, {3, 2}
        }));
    }

    private static int largestComponent(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i<n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                max = Math.max(max, traverse(i, adj, visited));
            }
        }
        return max;
    }

    private static int traverse(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        if (visited[node]) return 0;
        visited[node] = true;
        int count = 1;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor])
                count += traverse(neighbor, adj, visited);
        }
        return count;
    }
}
