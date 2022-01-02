package com.learn.ds.ll;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
