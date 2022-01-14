package com.learn.ds.graph;

import java.util.*;

public class MinimumHeightTrees {
    private static Map<Integer, List<Integer>> adj = new HashMap<>();
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> nodes = new ArrayList<>();
        if (edges.length == 0) {
            nodes.add(0);
            return nodes;
        }

        // create adj matrix
        for (int[] edge : edges) {
            adj.put(edge[0], new ArrayList<>());
            adj.put(edge[1], new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n = n - size;
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                List<Integer> adjList = adj.get(v);
                for (int j = 0; j < adjList.size(); j++) {
                    degree[adjList.get(j)]--;
                    if (degree[adjList.get(j)] == 1) {
                        queue.offer(adjList.get(j));
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            nodes.add(queue.poll());
        }
        return nodes;

    }

    public static void main(String[] args) {
        //System.out.println(findMinHeightTrees(6, new int[][] {{0,1},{0,2},{0,3},{3,4},{4,5}}));
        System.out.println(findMinHeightTrees(3, new int[][] {{0,1},{0,2}}));
    }
}
