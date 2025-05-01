package com.leetcode.journey.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/word-search-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: Build a Trie from the words
        TrieNode root = buildTrie(words);
        Set<String> result = new HashSet<>();

        // Step 2: Backtracking search on the board
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                backtrack(board, i, j, root, "", visited, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void backtrack(char[][] board, int row, int col, TrieNode node, String word, boolean[][] visited, Set<String> result) {
        // Boundary checks and visited check
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
            return;
        }

        char c = board[row][col];
        if (node.children[c - 'a'] == null) {
            return; // No word starts with this prefix
        }

        node = node.children[c - 'a'];
        word += c;

        if (node.isEnd) {
            result.add(word); // Found a valid word
        }

        visited[row][col] = true;

        // Explore neighbors (up, down, left, right)
        backtrack(board, row - 1, col, node, word, visited, result);
        backtrack(board, row + 1, col, node, word, visited, result);
        backtrack(board, row, col - 1, node, word, visited, result);
        backtrack(board, row, col + 1, node, word, visited, result);

        visited[row][col] = false; // Backtrack
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
        return root;
    }
}

