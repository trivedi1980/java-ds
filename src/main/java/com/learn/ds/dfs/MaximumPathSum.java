package com.learn.ds.dfs;

public class MaximumPathSum {
    public static int findMaximumPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] maxSum = new int[1];
        findHeightWeight(root, maxSum);
        return maxSum[0];
    }

    private static int findHeightWeight(TreeNode root, int[] maxSum) {
        if (root == null) return 0;

        int leftWeight = findHeightWeight(root.left, maxSum);
        int rightWeight = findHeightWeight(root.right, maxSum);

        maxSum[0] = Math.max(maxSum[0], leftWeight + rightWeight + root.val);

        return root.val + Math.max(leftWeight, rightWeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
