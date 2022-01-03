package com.learn.ds.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {
    public static void connect(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (prev == null) {
                    prev = curr;
                } else {
                    prev.next = curr;
                    prev = curr;
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
