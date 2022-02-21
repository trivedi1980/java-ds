package com.learn.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            rebalance();
        }


        int ws = 0;
        int we = k -1;

        while (we < nums.length) {
            medians[ws] = getMedian();
            ws++;
            we++;
            if (we >= nums.length) break;

            int num = nums[ws - 1];
            if (maxHeap.size() > 0 && num <= maxHeap.peek()) {
                maxHeap.remove(num);
                rebalance();
            } else if (minHeap.size() > 0 && num >= minHeap.peek()) {
                minHeap.remove(num);
                rebalance();
            }

            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[we]) {
                maxHeap.offer(nums[we]);
            } else {
                minHeap.offer(nums[we]);
            }
            rebalance();
        }
        return medians;
    }

    private double getMedian() {
        int diff = maxHeap.size() - minHeap.size();
        if (diff == 0) {
            return (((long)maxHeap.peek()) + ((long)minHeap.peek())) / 2.0;
        } else if (diff > 0) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    private void rebalance() {
        int diff = maxHeap.size() - minHeap.size();

        if (diff == 0 || diff == 1) return;

        if (diff == 2) {
            int item = maxHeap.poll();
            minHeap.offer(item);
        } else {
            int item = minHeap.poll();
            maxHeap.offer(item);
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7},
                3)));
    }
}
