package com.leetcode.journey.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class RandomizedSet {
    private Map<Integer, Integer> map; // Maps value to its index in the list
    private List<Integer> list; // Stores the elements
    private Random random; // For generating random indices

    // Constructor to initialize the data structures
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    // Inserts a value into the set. Returns true if the value was not already present.
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Value already exists
        }
        map.put(val, list.size()); // Map the value to its index in the list
        list.add(val); // Add the value to the list
        return true;
    }

    // Removes a value from the set. Returns true if the value was present.
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Value does not exist
        }
        int index = map.get(val); // Get the index of the value
        int lastElement = list.get(list.size() - 1); // Get the last element in the list

        // Swap the value to be removed with the last element
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    // Returns a random element from the set.
    public int getRandom() {
        int randomIndex = random.nextInt(list.size()); // Generate a random index
        return list.get(randomIndex); // Return the element at the random index
    }
}
