package com.learn.ds;

import java.util.Arrays;

public class MinTime {
    public static long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long minTime = time[0];
        long maxTime = ((long) totalTrips * (long)time[0]);

        return findMin(minTime, maxTime, totalTrips, time);
    }

    private static long findMin(long min, long max, int totalTrips, int[] time) {
        long start = min;
        long end = max;
        long result = -1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long count = tripsCount(mid, time);
            if (count >= totalTrips) {
                result = mid;
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static long tripsCount (long value, int[] time) {
        long count = 0;
        for (int each : time) {
            count += value / each;
        }
        return count;
    }

    public static void main(String[] args) {
        minimumTime(new int[] {10000}, 10000000);
    }
}
