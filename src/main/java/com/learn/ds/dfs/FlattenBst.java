package com.learn.ds.dfs;

public class FlattenBst {
    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;

        if (root.left != null)
            root.right = root.left;
        if (root.right != null) {
            TreeNode right = root.right;
            while (right.right != null) {
                right = right.right;
            }
            right.right = temp;
        }

        root.left = null;
    }

    public static void main(String[] args) {
        //[1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        root.left = left;
        TreeNode right = new TreeNode(5);
        right.right = new TreeNode(6);
        root.right = right;
        flatten(root);
    }
}
