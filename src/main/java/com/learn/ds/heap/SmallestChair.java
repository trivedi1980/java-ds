package com.learn.ds.heap;

import java.util.*;

public class SmallestChair {
    private static class Event {
        int time;
        int index;
        boolean isStart;

        public Event(int index, int time, boolean isStart) {
            this.index = index;
            this.time = time;
            this.isStart = isStart;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        List<Event> events = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < times.length; i++) {
            events.add(new Event(i, times[i][0], true));
            events.add(new Event(i, times[i][1], false));
            minHeap.offer(i);
        }

        Collections.sort(events, (a, b) -> {
            if (a.time == b.time) {
                return Boolean.compare(a.isStart, b.isStart);
            }
            return a.time - b.time;
        });
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.isStart) {
                int chair = minHeap.poll();
                map.put(event.index, chair);
            } else {
                minHeap.offer(map.get(event.index));
                map.remove(event.index);
            }
            if (event.index == targetFriend) return map.get(event.index);
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestChair instance = new SmallestChair();
        int chair = instance.smallestChair(new int[][] {{18,19},{10,11},{21,22},{5,6},{2,3},{6,7},{43,44},{48,49},{53,54},{12,13},{20,21},{34,35},{17,18},{1,2},{35,36},{16,17},{9,10},{14,15},{25,26},{37,38},{30,31},{50,51},{22,23},{3,4},{27,28},{29,30},{33,34},{39,40},{49,50},{15,16},{4,5},{46,47},{51,52},{32,33},{11,12},{28,29},{47,48},{36,37},{40,41},{42,43},{52,53},{41,42},{31,32},{23,24},{8,9},{19,20},{24,25},{26,27},{45,46},{44,45},{7,8},{13,14},{38,39}}, 8);
        System.out.println(chair);
    }
}
