package com.learn.ds.graph;

import java.util.*;

public class NetworkBecomesIdle {
    public static int networkBecomesIdle(int[][] edges, int[] patience) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> shortDistance = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < patience.length; i++) {
            adj.put(i, new ArrayList<>());
            shortDistance.put(i, i == 0 ? 0 : Integer.MAX_VALUE);
            minHeap.offer(new int[] {i, shortDistance.get(i)});
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            if (visited.contains(cur[0])) continue;

            visited.add(cur[0]);
            for (int neighbor : adj.get(cur[0])) {
                int oldDistance = shortDistance.get(neighbor);
                int newDistance = 1 + cur[1];
                if (newDistance < oldDistance) {
                    shortDistance.put(neighbor, newDistance);
                    minHeap.offer(new int[] {neighbor, newDistance});
                }
            }
        }

        int max = 0;
        for (int i = 1; i < patience.length; i++) {
            int distance = shortDistance.get(i);
            int p = patience[i];
            int td = distance * 2;
            int noOfMessages = td % p > 0 ?  (td / p) + 1 : td / p;
            int time;
            if (noOfMessages > 1)
                time = distance * 2 + (noOfMessages - 1) * p;
            else
                time = distance * 2;
            max = Math.max(max, time);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        //[[0,1],[0,2],[1,2]]
        //[0,10,10]
        /*System.out.println(networkBecomesIdle(new int[][] {
                {0,1},{1,2}
        }, new int[] {0, 2, 1}));*/

        /*System.out.println(networkBecomesIdle(new int[][] {
                {0,1},{0,2},{1,2}
        }, new int[] {0, 10, 10}));*/

        //[[3,8],[4,13],[0,7],[0,4],[1,8],[14,1],[7,2],[13,10],[9,11],[12,14],[0,6],[2,12],[11,5],[6,9],[10,3]]
        // [0,3,2,1,5,1,5,5,3,1,2,2,2,2,1]

        System.out.println(networkBecomesIdle(new int[][] {
                {3,8},{4,13},{0,7},{0,4},{1,8},{14,1},{7,2},{13,10},{9,11},{12,14},{0,6},{2,12},{11,5},{6,9},{10,3}
        }, new int[]{0,3,2,1,5,1,5,5,3,1,2,2,2,2,1}));
    }
}
