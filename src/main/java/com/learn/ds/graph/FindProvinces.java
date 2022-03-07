package com.learn.ds.graph;

import java.util.*;

public class FindProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < isConnected.length; i++) {
            adj.put(i, new ArrayList<>());
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                provinces++;
                visitProvinces(i, adj, visited);
            }
        }
        return provinces;
    }

    private void visitProvinces(int city, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        visited.add(city);
        for (int each : adj.get(city)) {
            if (!visited.contains(each)) visitProvinces(each, adj, visited);
        }
    }

    public static void main(String[] args) {
        FindProvinces f = new FindProvinces();
        System.out.println(f.findCircleNum(new int[][] {
                // [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
                {1,0,0,1},{0,1,1,0},{0,1,1,1}, {1,0,1,1}
        }));
    }
}
