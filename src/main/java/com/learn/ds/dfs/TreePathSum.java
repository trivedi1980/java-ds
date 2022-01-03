package com.learn.ds.dfs;

public class TreePathSum {
    private static boolean hasPath(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private static boolean dfs(TreeNode root, int sum) {
        if (sum == 0) return true;
        if (root == null || sum < 0) return false;

        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};
