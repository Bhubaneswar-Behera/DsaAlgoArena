package com.leetcode.journey.linkedlist.stacks.queues;

/**
 *
 * https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        // Create two dummy nodes for two partitions
        ListNode lessHead = new ListNode(0); // Nodes less than x
        ListNode greaterHead = new ListNode(0); // Nodes greater than or equal to x

        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse the list and partition the nodes
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Connect the two partitions
        greater.next = null; // End the greater list
        less.next = greaterHead.next; // Connect less list to greater list

        return lessHead.next; // Return the head of the new list
    }
}
