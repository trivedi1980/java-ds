package com.learn.ds.fsp;

import javax.swing.*;

public class RearrangeList {
    public static void reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow will be in the middle
        // reverse the second half
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = slow.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
        }

        ListNode left = head;
        ListNode right = prev;

        while (left != null && right != null) {
            next = left.next;
            left.next = right;
            right = right.next;
            left.next.next = next;
            left = next;
        }
        if (left != null)
            left.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
