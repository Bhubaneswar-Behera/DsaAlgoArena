package com.leetcode.journey.linkedlist.stacks.queues;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class ReverseNodesInkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode groupStart = current;
            int count = 0;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            if (count < k) {
                break; // Not enough nodes to reverse
            }

            // Reverse the k nodes
            ListNode prev = null;
            ListNode next = null;
            current = groupStart;
            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Connect the reversed group with the previous and next groups
            prevGroupEnd.next = prev; // prev is the new head of the reversed group
            groupStart.next = current; // groupStart is now the tail of the reversed group

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
}
