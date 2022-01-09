package com.learn.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindRightInterval {
    public static int[] findRightInterval(int[][] intervals) {
        if (intervals.length <= 1) return new int[] { -1 };
        int[] result = new int[intervals.length];

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.data[0] - b.data[0]);
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] { {1,4},{2,3},{3,4}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }
}

class Interval {
    int[] data;
    int index;
    Interval(int[] data, int index) {
        this.data = data;
        this.index = index;
    }
}
