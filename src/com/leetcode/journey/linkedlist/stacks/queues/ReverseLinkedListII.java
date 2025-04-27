package com.leetcode.journey.linkedlist.stacks.queues;

/**
 *
 *https://leetcode.com/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist from `left` to `right`
        ListNode current = prev.next;
        ListNode next = null;
        ListNode prevSublist = null;

        for (int i = 0; i < right - left + 1; i++) {
            next = current.next;
            current.next = prevSublist;
            prevSublist = current;
            current = next;
        }

        // Step 3: Reconnect the reversed sublist with the rest of the list
        prev.next.next = current; // Connect the tail of the reversed sublist
        prev.next = prevSublist; // Connect the head of the reversed sublist

        return dummy.next;
    }
}
