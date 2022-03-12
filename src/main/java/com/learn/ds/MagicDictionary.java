package com.learn.ds;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

public class MagicDictionary {

    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String each : dictionary) {
            addString(each);
        }
    }

    public boolean search(String searchWord) {
        TrieNode curr = this.root;
        int count = 0;
        int index = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            if (!curr.children.containsKey(ch)) {
                count++;
                index = i;
                break;
            } else {
                curr = curr.children.get(ch);
            }
        }
        if (count == 0) return false;
        return findSubString(searchWord, index + 1, curr);
    }

    private boolean findSubString(String word, int index, TrieNode node) {
        char ch = word.charAt(index);
        for (Character each : node.children.keySet()) {
            TrieNode curr = node.children.get(each);

            if (curr.children.containsKey(ch) && search(word, index, curr))
                return true;
        }
        return false;
    }

    private boolean search(String word, int index, TrieNode node) {
        TrieNode curr = node;
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.children.containsKey(ch)) return false;
            curr = curr.children.get(ch);
        }
        return curr.isEnd;
    }

    private void addString(String word) {
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

    public static void main(String[] args) {
       // ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello","hallo","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[] {"hello", "hallo", "leetcode"});
        md.search("hello");
    }
}

