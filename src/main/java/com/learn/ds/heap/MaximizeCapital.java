package com.learn.ds.heap;

import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int findMaximumCapital(int[] capital,
                                         int[] profits,
                                         int numberOfProjects,
                                         int initialCapital) {
        int max = initialCapital;
        PriorityQueue<Project> minCapHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.capital, p2.capital));
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.profit, p1.profit));

        for (int i = 0; i < capital.length; i++) {
            minCapHeap.offer(new Project(capital[i], profits[i]));
        }

        for (int i = 0; i < numberOfProjects; i++) {
            while (!minCapHeap.isEmpty() && minCapHeap.peek().capital <= max)
                maxProfitHeap.offer(minCapHeap.poll());

            if (maxProfitHeap.isEmpty()) break;
            max += maxProfitHeap.poll().profit;
        }
        return max;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 10, 0);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}

class Project {
    int capital;
    int profit;

    Project(int c, int p) {
        this.capital = c;
        this.profit = p;
    }
}
