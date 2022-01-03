package com.learn.ds.dfs;

public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        return dfsPathLookup(root, sequence, 0);
    }

    private static boolean dfsPathLookup(TreeNode root, int[] sequence, int index) {
        if (root == null) return false;
        if (index >= sequence.length || sequence[index] != root.val) return false;

        if (root.left == null && root.right == null && index == sequence.length - 1) return true;

        return dfsPathLookup(root.left, sequence, index + 1)
                    || dfsPathLookup(root.right, sequence, index + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
