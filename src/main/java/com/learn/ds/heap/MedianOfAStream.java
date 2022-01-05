package com.learn.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAStream {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void insertNum(int num) {
        if (maxHeap.size() == 0 || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        int diff = minHeap.size() - maxHeap.size();

        if (diff >= 2) {
            maxHeap.offer(minHeap.poll());
        } else if (diff <= -2) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        int diff = minHeap.size() - maxHeap.size();

        if (diff == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (diff > 0) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(-1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(-2);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(-3);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(-4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(-5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
