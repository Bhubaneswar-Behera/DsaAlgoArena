package com.leetcode.journey.trie;

 public class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26]; // For 'a' to 'z'
            isEnd = false;
        }
    }

