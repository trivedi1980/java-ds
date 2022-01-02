package com.learn.ds.ll;

public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        ListNode newHead = null;

        while (true) {
            int i = 1;
            ListNode prevHead = curr;
            next = curr.next;
            while (i <= k && curr != null) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
                i++;
            }
            if (newHead == null)
                newHead = prev;
            else
                prevHead.next.next = prev;

            prevHead.next = curr;
            i = 1;

            while (i <= k && curr != null) {
                prev = curr;
                curr = curr.next;
                i++;
            }
            if (curr == null) break;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 5);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
