package com.learn.ds.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums [i-1]) continue;
            if (minHeap.size() < k) {
                minHeap.offer(new int[] { nums[i], mapCount.get(nums[i])});
            } else {
                int[] min = minHeap.peek();
                if (min[1] < mapCount.get(nums[i])) {
                    minHeap.poll();
                    minHeap.offer(new int[] { nums[i], mapCount.get(nums[i])});
                }
            }
        }

        int[] f = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            f[i++] = minHeap.poll()[0];
        }
        return f;
    }
    public static void main(String[] args) {
        // [1,1,1,2,2,3]
        // 2
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3}, 2)));
    }
}
