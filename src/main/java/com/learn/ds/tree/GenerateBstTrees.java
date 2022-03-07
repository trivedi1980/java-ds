package com.learn.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateBstTrees {
    public static List<TreeNode> generateTrees(int n) {
        return buildTrees(1, n);
    }

    private static List<TreeNode> buildTrees(int start, int end) {
        if (start > end) {
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }

        List<TreeNode> trees = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = buildTrees(start, i -1);
            List<TreeNode> rights = buildTrees(i+1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    trees.add(node);
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
