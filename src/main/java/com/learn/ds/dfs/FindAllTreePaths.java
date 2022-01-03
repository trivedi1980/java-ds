package com.learn.ds.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(root, sum, allPaths, new ArrayList<>());
        return allPaths;
    }

    private static void dfs (TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> currPath) {
        if (root == null || sum < 0) return;

        currPath.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currPath));
        } else {
            dfs(root.left, sum - root.val, allPaths, currPath);
            dfs(root.right, sum - root.val, allPaths, currPath);
        }
        currPath.remove(currPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
