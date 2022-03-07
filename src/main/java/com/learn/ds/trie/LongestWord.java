package com.learn.ds.trie;

import java.util.HashSet;
import java.util.Set;

public class LongestWord {
    private TrieNode root = new TrieNode();

    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>();

        for (String word : words) {
            populate(word);
            wordSet.add(word);
        }

        String result = "";
        for (int i = 0; i < root.childern.length; i++) {
            String lw = findWord(i, root.childern[i], wordSet, new StringBuilder());
            if (result.length() < lw.length()) {
                result = lw;
            }
        }
        return result;
    }

    private String findWord(int index, TrieNode node, Set<String> wordSet, StringBuilder sb) {
        if (node == null) return "";
        sb.append((char)('a' + index));
        if (!wordSet.contains(sb.toString())) {
            sb.deleteCharAt(sb.length() -1);
            return "";
        }

        String word = node.isEnd ? sb.toString() : "";
        for (int i = 0; i < node.childern.length; i++) {
            String lw = findWord(i, node.childern[i], wordSet, sb);
            if (word.length() < lw.length()) {
                word = lw;
            }
        }
        sb.deleteCharAt(sb.length() -1);
        return word;
    }

    private void populate(String word) {
        TrieNode cur = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.childern[ch - 'a'] == null) {
                cur.childern[ch - 'a'] = new TrieNode();
            }
            cur = cur.childern[ch - 'a'];
        }
        cur.isEnd = true;
    }

    class TrieNode {
        TrieNode[] childern;
        boolean isEnd;

        TrieNode() {
            this.childern = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        LongestWord lw = new LongestWord();
        //["rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"]
        System.out.println(lw.longestWord(new String[] {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"}));
    }
}
