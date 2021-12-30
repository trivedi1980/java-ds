package com.learn.ds.mi;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intersections = new ArrayList<>();
        int one = 0;
        int two = 0;
        while (one < arr1.length && two < arr2.length) {
            if (arr2[two].start > arr1[one].end) {
                one++;
            } else if (arr2[two].end < arr1[one].start) {
                two++;
            } else {
                intersections.add(new Interval(Math.max(arr1[one].start, arr2[two].start),
                        Math.min(arr1[one].end, arr2[two].end)));
                if (arr1[one].end == arr2[two].end) {
                    one++;
                    two++;
                } else if (arr1[one].end > arr2[two].end) {
                    two++;
                } else {
                    one++;
                }
            }
        }
        return intersections.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
