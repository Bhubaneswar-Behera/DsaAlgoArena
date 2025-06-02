package com.neetcode150.linkedlist;

/**
 *
 * https://www.youtube.com/watch?v=t7YaoQOFXzk
 */
 class ListNode {

    static ListNode head = null;
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }



    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void printList() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static  void reverseList() {
          if (head == null || head.next == null) {
            System.out.println("List is empty or has only one element");
            return;
          }

        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next; // Store the next node
            currentNode.next = previousNode; // Reverse the link
            previousNode = currentNode; // Move previousNode to currentNode
            currentNode = nextNode; // Move to the next node
        }

        head = previousNode; // Update head to the new first node

    }
 }



public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.addLast(1);
        listNode.addLast(2);
        listNode.addLast(3);
        listNode.addLast(4);
        listNode.addLast(5);
        System.out.println("Original List:");
        listNode.printList();

        System.out.println("Reversed List:");
        listNode.reverseList();
        listNode.printList();


    }
    public static ListNode reverseList(ListNode head) {

        return null;
    }
}
