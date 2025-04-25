package com.leetcode.journey.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> result = fullJustify(words, maxWidth);

        // Print the result
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineLength = words[index].length();
            int last = index + 1;

            // Determine how many words can fit in the current line
            while (last < words.length && lineLength + words[last].length() + (last - index) <= maxWidth) {
                lineLength += words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int wordCount = last - index;
            int spaces = maxWidth - lineLength;

            // Handle the last line or lines with a single word
            if (last == words.length || wordCount == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ");
                    }
                }
                // Pad the remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Distribute spaces evenly between words
                int spaceBetweenWords = spaces / (wordCount - 1);
                int extraSpaces = spaces % (wordCount - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j < spaceBetweenWords; j++) {
                            line.append(" ");
                        }
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }
}
