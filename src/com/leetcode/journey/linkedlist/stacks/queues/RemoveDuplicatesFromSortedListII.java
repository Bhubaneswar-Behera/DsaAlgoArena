package com.leetcode.journey.linkedlist.stacks.queues;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // Pointer to the node before the current sequence

        while (head != null) {
            // If the current node has duplicates, skip all nodes with the same value
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Skip the entire sequence of duplicates
                prev.next = head.next;
            } else {
                // Move the prev pointer if no duplicates are found
                prev = prev.next;
            }
            head = head.next; // Move to the next node
        }

        return dummy.next;
    }
}
