package com.learn.ds.graph;

import java.util.*;

public class NetworkDelay {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Map<Integer, Integer> nodeTimes = new HashMap<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
            int[] nodeTime = new int[] {i, k == i ? 0 : Integer.MAX_VALUE};
            nodeTimes.put(i, nodeTime[1]);
            minHeap.add(nodeTime);
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new int[] { time[1], time[2]});
        }

        Set<Integer> spt = new HashSet<>();

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (spt.contains(curr[0])) continue;

            spt.add(curr[0]);
            for (int[] neighbor: adj.get(curr[0])) {
                int nodeTime = nodeTimes.get(neighbor[0]);
                int newTime = Math.min(nodeTime, neighbor[1] + curr[1]);
                if (newTime != nodeTime) {
                    minHeap.offer(new int[] { neighbor[0], newTime});
                    nodeTimes.put(neighbor[0], newTime);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int nodeTime = nodeTimes.get(i);
            if (nodeTime == Integer.MAX_VALUE) return -1;
            max = Math.max(max, nodeTime);
        }
        return max;
    }

    public static void main(String[] args) {
        // [[2,1,1],[2,3,1],[3,4,1]]
        // 4
        // 2
        /*System.out.println(networkDelayTime(new int[][] {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        }, 4, 2));*/

        //[[1,2,1],[2,3,2],[1,3,2]]
        //3
        //1

        //[[1,2,1],[2,3,7],[1,3,4],[2,1,2]]
        //3
        //2

        // [[4,2,76],[1,3,79],[3,1,81],[4,3,30],[2,1,47],[1,5,61],[1,4,99],[3,4,68],[3,5,46],[4,1,6],
        // [5,4,7],[5,3,44],[4,5,19],[2,3,13],[3,2,18],[1,2,0],[5,1,25],[2,5,58],[2,4,77],[5,2,74]]
        // 5
        // 3


        System.out.println(networkDelayTime(new int[][] {
                {4, 2, 76},
                {1, 3, 79},
                {3, 1, 81},
                {4, 3, 30},
                {2, 1, 47},
                {1, 5, 61},
                {1, 4, 99},
                {3, 4, 68},
                {3, 5, 46},
                {4, 1, 6},
                {5, 4, 7},
                {5, 3, 44},
                {4, 5, 19},
                {2, 3, 13},
                {3, 2, 18},
                {1, 2, 0},
                {5, 1, 25},
                {2, 5, 58},
                {2, 4, 77},
                {5, 2, 74},
        }, 5, 3));
    }
}
