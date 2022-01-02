package com.learn.ds.ll;

public class RotateList {
    public static ListNode rotate(ListNode head, int rotations) {
        ListNode prev = null;
        ListNode curr = head;
        int i = 1;
        while (i <= rotations && curr != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode endNode = head;
        while (endNode.next != null) {
            endNode = endNode.next;
        }
        endNode.next = head;
        head = curr;
        prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
