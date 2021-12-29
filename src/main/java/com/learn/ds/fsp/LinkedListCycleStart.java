package com.learn.ds.fsp;

public class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        int cycleLength = findCycleLength(head);
        ListNode p1 = head;
        ListNode p2 = head;

        // move p2 by cycle length nodes
        for (int i = 0; i < cycleLength; i++) {
            p2 = p2.next;
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode current = slow.next;
                count++;
                while (current != slow) {
                    current = current.next;
                    count++;
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
