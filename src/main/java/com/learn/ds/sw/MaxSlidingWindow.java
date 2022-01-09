package com.learn.ds.sw;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n2.value, n1.value));

        for (int i = 0; i < k; i++) {
            int ele = nums[i];
            maxHeap.offer(new Node(ele, i));
        }

        for (int i = 0; i< nums.length - k + 1; i++) {
            Node node = maxHeap.peek();
            if (node.index >= i && node.index < i + k) {
                result[i] = node.value;
                if (i + k < nums.length)
                    maxHeap.offer(new Node(nums[i + k], i+k));
            } else {
                maxHeap.poll();
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1,-1},
        1)));
    }
}

class Node {
    int value;
    int index;

    Node(int val, int index) {
        this.value = val;
        this.index = index;
    }
}
