package com.learn.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedComponents {
    public static int connectedComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                traverse(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    private static void traverse(int node,
                                 Map<Integer, List<Integer>> adj,
                                 boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;

        for (int v : adj.get(node)) {
            traverse(v, adj, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println(connectedComponents(8, new int[][] {
            {1, 2}, {4, 6}, {6, 8}, {5, 6}, {6, 7}
        }));
    }
}
