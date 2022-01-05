package com.learn.ds.dfs;

public class DiameterOfBinaryTree {
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        height(root, d);
        return d[0];
    }

    private static int height(TreeNode root, int[] d) {
        if (root == null) return 0;

        int leftH = height(root.left, d);
        int rightH = height(root.right, d);

        d[0] = Math.max(d[0], leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + diameterOfBinaryTree(root));
    }
}
