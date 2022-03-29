package com.learn.ds.heap;

import java.util.PriorityQueue;

public class KLargestItemInArray {
    private static class Item {
        String num;
        int index;
        public Item(String num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<Item> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.num.equals(b.num)) {
                return Integer.compare(a.index, b.index);
            } else if (a.num.length() != b.num.length()) {
                return Integer.compare(a.num.length(), b.num.length());
            }
            return a.num.compareTo(b.num);
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new Item(nums[i], i));
            if (minHeap.size() >= k) {
                minHeap.poll();
            }
        }

        return minHeap.peek().num;
    }

    public static void main(String[] args) {
        //["3","6","7","10"]
        //4
        KLargestItemInArray instance = new KLargestItemInArray();
        instance.kthLargestNumber(new String[] {"3","6","7","10"}, 4);
    }
}
