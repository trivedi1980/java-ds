package com.learn.ds.mi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) return 0;

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b. start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(meetings.get(0).end);
        for (int i = 1; i < meetings.size(); i++) {
            Meeting m = meetings.get(i);
            if (m.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(m.end);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        // [[0,2],[1,3],[2,4],[3,5],[4,6]]
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(0, 2));
                add(new Meeting(1, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
                add(new Meeting(4, 6));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};
