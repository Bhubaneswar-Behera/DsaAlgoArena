package com.leetcode.journey.linkedlist.stacks.queues;

/**
 *
 * https://leetcode.com/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Optimize k
        k = k % length;
        if (k == 0) {
            return head;
        }

        // Step 3: Make the list circular
        current.next = head;

        // Step 4: Find the new tail (length - k steps from the head)
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle and set the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
