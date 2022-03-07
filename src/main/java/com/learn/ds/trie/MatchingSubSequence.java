package com.learn.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class MatchingSubSequence {
    public int numMatchingSubseq(String s, String[] words) {
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.isEnd = true;

        int count = 0;
        for (String word : words) {
            if (isSubSequence(word, root)) count++;
        }
        return count;
    }

    private boolean isSubSequence(String word, TrieNode node) {
        TrieNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            cur = findChar(word.charAt(i), cur);
            if (cur == null) return false;
        }
        return true;
    }

    private TrieNode findChar(char ch, TrieNode node) {
        if (node == null) return null;
        if (node.children.containsKey(ch)) return node.children.get(ch);
        if (node.isEnd) return null;

        for (char key : node.children.keySet()) {
            TrieNode tn = findChar(ch, node.children.get(key));
            if (tn != null) return tn;
        }
        return null;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        MatchingSubSequence seq = new MatchingSubSequence();
        System.out.println(seq.numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
    }
}
