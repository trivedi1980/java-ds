package com.learn.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSerialize {
    public static String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        serialize(root, list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] items = data.split(",");
        return deserialize(items, new int[] {0});
    }

    private static TreeNode deserialize(String[] items, int[] index) {
        if (index[0] < 0 || index[0] >= items.length) return null;
        if (items[index[0]].equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(items[index[0]]));
        index[0] = index[0] + 1;
        node.left = deserialize(items, index);
        index[0] = index[0] + 1;
        node.right = deserialize(items, index);
        return node;
    }

    private static void serialize(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        }

        list.add(node.val);
        serialize(node.left, list);
        serialize(node.right, list);
        /*Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (tn == null) {
                    list.add(null);
                    continue;
                }

                list.add(tn.val);
                queue.offer(tn.left);
                queue.offer(tn.right);
            }
        }*/
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = serialize(root);
        TreeNode copy = deserialize(str);
    }
}
