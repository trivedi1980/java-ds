package com.learn.ds.tree;

import java.util.*;

public class FindDuplicateTrees {
    private Set<String> visited = new HashSet<>();
    private Map<String, TreeNode> duplicate = new HashMap<>();

    public boolean isValidSerialization(String preorder) {
        int[] index = new int[] {0};
        String[] values = preorder.split(",");
        if (traverse(values, index))
            return index[0] == values.length - 1;
        return false;
    }

    private boolean traverse(String[] preorder, int[] index) {
        if (index[0] >= preorder.length) return false;
        if (preorder[index[0]].equals("#")) return true;

        index[0] += 1;
        boolean left = traverse(preorder, index);
        index[0] += 1;
        boolean right = traverse(preorder, index);
        return left && right;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorder(root);
        return new ArrayList<>(duplicate.values());
    }

    private String preorder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        String left = "X";
        String right = "X";

        if (node.left != null) {
            left = preorder(node.left);
        }

        if (node.right != null) {
            right = preorder(node.right);
        }

        sb.append(node.val);
        sb.append(",");
        sb.append(left);
        sb.append(",");
        sb.append(right);
        String str = sb.toString();

        if (visited.contains(str)) {
            duplicate.put(str, node);
        }
        visited.add(str);
        return str;
    }

    public static void main(String[] args) {
        FindDuplicateTrees instance = new FindDuplicateTrees();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        instance.findDuplicateSubtrees(root);
        System.out.println(instance.isValidSerialization("9,#,#,1"));
    }
}
