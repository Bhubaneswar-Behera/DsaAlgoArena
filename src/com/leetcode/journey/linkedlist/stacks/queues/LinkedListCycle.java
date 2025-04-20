package com.leetcode.journey.linkedlist.stacks.queues;


/**
 * https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 *
 */


public class LinkedListCycle {
    public static void main(String[] args) {
// Example usage
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creates a cycle

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1 step
            fast = fast.next.next; // Move fast pointer by 2 steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }
}
