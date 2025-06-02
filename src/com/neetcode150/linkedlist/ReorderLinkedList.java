package com.neetcode150.linkedlist;

/**
 *
 * https://leetcode.com/problems/reorder-list/description/
 * Reference : https://www.youtube.com/watch?v=Pno7rUOZM-o
 */
public class ReorderLinkedList {

    class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ReorderLinkedList reorderLinkedList = new ReorderLinkedList();
        ListNode head = reorderLinkedList.new ListNode(1);
        head.next = reorderLinkedList.new ListNode(2);
        head.next.next = reorderLinkedList.new ListNode(3);
        head.next.next.next = reorderLinkedList.new ListNode(4);
        head.next.next.next.next = reorderLinkedList.new ListNode(5);

        reorderLinkedList.reorderList(head);

        // Print the reordered list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) { // base case
            return;
        }
        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow by 1 step
            fast = fast.next.next; // move fast by 2 steps
        }
        // Step 2: Reverse the second half of the linked list
        ListNode prev = null;
        ListNode current = slow;
        ListNode nextTemp = null;
        while (current != null) {
            nextTemp = current.next; // store the next node
            current.next = prev; // reverse the link
            prev = current; // move prev to current
            current = nextTemp; // move to the next node
        }

        // Step 3: Merge the two halves
        ListNode first = head; // start from the first half
        ListNode second = prev; // start from the reversed second half
        while (second.next != null) { // while there are nodes in the second half
            ListNode temp1 = first.next; // store the next node of the first half
            ListNode temp2 = second.next; // store the next node of the second half

            first.next = second; // link first to second
            second.next = temp1; // link second to the next node of first

            first = temp1; // move to the next node in the first half
            second = temp2; // move to the next node in the second half
        }
    }
}
