package com.learn.ds.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TestPq {
    public static void main(String[] args) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        min.offer(new int[]{ 1, 1});
        min.offer(new int[]{ 1, 0});

        while (!min.isEmpty()) {
            int[] item = min.poll();
            System.out.println(Arrays.toString(item));
            min.offer(new int[]{ 1, -1});
        }

        System.out.println(min);
    }
}
