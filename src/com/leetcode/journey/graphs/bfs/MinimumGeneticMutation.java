package com.leetcode.journey.graphs.bfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        MinimumGeneticMutation solution = new MinimumGeneticMutation();
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(solution.minMutation(startGene, endGene, bank)); // Output: 1
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1; // If endGene is not in the bank, return -1
        }

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) {
                    return mutations; // Found the endGene
                }

                // Generate all possible mutations
                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char originalChar = currentArray[j];
                    for (char gene : genes) {
                        if (gene != originalChar) {
                            currentArray[j] = gene;
                            String mutatedGene = new String(currentArray);
                            if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                                queue.offer(mutatedGene);
                                visited.add(mutatedGene);
                            }
                        }
                    }
                    currentArray[j] = originalChar; // Restore the original character
                }
            }
            mutations++;
        }

        return -1; // If no valid mutation path is found
    }

}
