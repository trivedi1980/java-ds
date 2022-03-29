package com.learn.ds.tree;

public class Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] items = data.split(",");
        int[] index = new int[]{0};
        return deserialize(items, index);
    }

    private static TreeNode deserialize(String[] items, int[] index) {
        if (items[index[0]].equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(items[index[0]]));
        index[0]++;
        node.left = deserialize(items, index);
        index[0]++;
        node.right = deserialize(items, index);
        return node;
    }

    private static void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        };
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        //node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        System.out.println(serialize(node));
        TreeNode newNode = deserialize("2,null,3,null,null,");
    }
}
