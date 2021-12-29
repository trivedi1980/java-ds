package com.learn.ds.fsp;

public class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half with slow and fast pointers
        ListNode prev = null;
        ListNode next = slow.next;
        while (slow != null) {
            slow.next = prev;
            prev = slow;
            slow = next;
            if (next != null)
                next = next.next;
        }

        ListNode left = head;
        ListNode right = prev;
        while (left != null && right != null) {
            if (left.value != right.value) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        //head.next.next.next.next.next = new ListNode(2);
        //System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
