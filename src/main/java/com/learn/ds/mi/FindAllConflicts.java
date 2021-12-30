package com.learn.ds.mi;

import java.util.Arrays;
import java.util.Comparator;

public class FindAllConflicts {
    public static void main(String[] args) {
        Interval[] intervals = { new Interval(4, 5), new Interval(2, 3),
                new Interval(3, 6), new Interval(5, 7), new Interval(7, 8)};
        FindAllConflicts.findAll(intervals);
    }

    private static void findAll(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(value -> value.start));
        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= prev.end) {
                prev = intervals[i];
            } else {
                System.out.println("conflict between: " + prev + ", " + intervals[i]);
                if (prev.end < intervals[i].end) {
                    prev = intervals[i];
                }
            }
        }
    }
}
