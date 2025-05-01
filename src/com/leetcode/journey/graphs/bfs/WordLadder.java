package com.leetcode.journey.graphs.bfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/word-ladder/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList)); // Output: 5
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // If endWord is not in the wordList, return 0
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return steps; // Found the endWord
                }

                // Generate all possible transformations
                char[] wordArray = currentWord.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != originalChar) {
                            wordArray[j] = c;
                            String transformedWord = new String(wordArray);
                            if (wordSet.contains(transformedWord)) {
                                queue.offer(transformedWord);
                                wordSet.remove(transformedWord); // Mark as visited
                            }
                        }
                    }
                    wordArray[j] = originalChar; // Restore the original character
                }
            }
            steps++;
        }

        return 0; // If no valid transformation path is found
    }
}
