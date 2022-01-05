package com.learn.ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Node head;
    private Node last;
    private Map<Integer, Node> nodes;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.last = null;
        this.nodes = new HashMap<>();
    }

    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            moveToEnd(node);
            return node.data;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (nodes.get(key) != null) {
            node = nodes.get(key);
            node.data = value;
        } else {
            node = new Node(value, key);
            nodes.put(key, node);
        }
        moveToEnd(node);

        if (nodes.size() > capacity) {
            evict();
        }
    }

    public void print() {
        System.out.println();
        Node curr = head;
        while (curr != null) {
            System.out.print("{" + curr.key + "->" + curr.data + "} ");
            curr = curr.next;
        }
    }

    private void moveToEnd(Node node) {
        if (head == null && last == null) {
            head = last = node;
            return;
        }

        if (node.prev == null && node.next == null) {
            last.next = node;
            node.prev = last;
            last = node;
            return;
        }

        if (node == head) {
            head = node.next;
            head.prev = null;
            last.next = node;
            node.prev = last;
            node.next = null;
            last = node;
            return;
        }

        if (node == last) {
            return;
        }

        // some where in the middle
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        last.next = node;
        node.prev = last;
        last = node;
    }

    private void evict() {
        if (head != null) {
            Node node = head;
            head = head.next;
            head.prev = null;
            node.prev = null;
            node.next = null;
            nodes.remove(node.key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        cache.put(3, 3);
        cache.print();
        cache.put(2, 4);
        cache.print();
    }
}

class Node {
    int data;
    int key;
    Node prev;
    Node next;

    public Node (int data, int key) {
        this.data = data;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

