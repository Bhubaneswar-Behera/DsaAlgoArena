package com.leetcode.journey.divide.and.conquer;

/**
 *
 * https://leetcode.com/problems/sort-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SortList {

    public static void main(String[] args) {
// Example input: [4, 2, 1, 3]
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode sortedHead = sortList(head);

        // Print the sorted list
        printList(sortedHead); // Output: [1, 2, 3, 4]
    }

    public static ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null;

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Merge the sorted halves
        return merge(left, right);
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
