package com.neetcode150.linkedlist;

/**
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseNodesInKGroup {

    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        // Example usage
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        ListNode head = solution.new ListNode(1, solution.new ListNode(2, solution.new ListNode(3, solution.new ListNode(4, solution.new ListNode(5)))));
        int k = 2;
        ListNode reversedList = solution.reverseKGroup(head, k);

        // Print the reversed list
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes to reverse
        ListNode currentNode = head;
        int count = 0;
        while ( count < k) {
            if(currentNode == null){
                return head;
            }
            currentNode = currentNode.next;
            count++;
        }

        // Recursive call on next group
        ListNode previousNode = reverseKGroup(currentNode, k);
        currentNode = head;
        count = 0;
        ListNode nextNode = null;
        while (count < k) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            count++;
        }

        return previousNode;

    }
}
