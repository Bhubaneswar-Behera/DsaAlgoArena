package com.neetcode150.graph;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/word-ladder/description/
 * Reference : https://www.youtube.com/watch?v=c9Myn-zYmJs
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = wl.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of the shortest transformation sequence: " + result);
        //Expected output: 5
        // Explanation: The sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // If endWord is not in the word list, return 0
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1; // Start with the length of the beginWord

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return length; // Found the endWord, return the length
                }

                for (int j = 0; j < currentWord.length(); j++) {
                    char[] chars = currentWord.toCharArray();
                    // Try changing each character to every letter from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Remove to prevent cycles
                        }
                    }
                }
            }
            length++; // Increment the length for the next level
        }

        return 0; // If we exhaust the queue without finding endWord, return 0
    }
}
