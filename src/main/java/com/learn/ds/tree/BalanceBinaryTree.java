package com.learn.ds.tree;

public class BalanceBinaryTree {
    public static TreeNode balanceBST(TreeNode root) {
        if (root == null) return root;

        int lh = height(root.left);
        int rh = height(root.right);

        int diff = lh - rh;

        if (diff >= 2) {
            TreeNode max = maxNode(root.left);
            max.left = delete(root.left, max.val);
            root.left = null;
            max.right = root;
            return balanceBST(max);
        } else if (diff <= -2) {
            TreeNode min = minNode(root.right);
            min.right = delete(root.right, min.val);
            root.right = null;
            min.left = root;
            return balanceBST(min);
        } else {
            return root;
        }
    }

    private static TreeNode delete(TreeNode node, int val) {
        if (node == null) return node;

        if (node.val == val) {
            if (node.left != null && node.right != null) {
                TreeNode min = minNode(node.right);
                node.val = min.val;
                node.right = delete(node.right, min.val);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        } else if (val < node.val) {
            node.left = delete(node.left, val);
            return node;
        } else {
            node.right = delete(node.right, val);
            return node;
        }
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static TreeNode maxNode(TreeNode node) {
        if (node.right == null) return node;
        return maxNode(node.right);
    }

    private static TreeNode minNode(TreeNode node) {
        if (node.left == null) return node;
        return minNode(node.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(17);
        root.right.left = new TreeNode(14);
        root.right.left.left = new TreeNode(7);
        root.right.left.left.right = new TreeNode(12);
        root.right.left.left.right.left = new TreeNode(9);
        root.right.left.left.right.left.right = new TreeNode(11);
        root.right.left.left.left = new TreeNode(2);
        root.right.left.left.left.right = new TreeNode(3);

        System.out.println(balanceBST(root));
    }
}
