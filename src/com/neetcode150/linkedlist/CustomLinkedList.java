package com.neetcode150.linkedlist;

public class CustomLinkedList {
    Node head = null;
    private int size = 0;

    CustomLinkedList(){
        this.size = 0;
    }

    class Node{
        String data;
        Node next;
        Node() {
        }

        Node(String data) {
            this.data = data;
        }
        Node(String data, Node next) {
            this.data = data;
            this.next = next;
            size++;
        }
    }

    //Add a new node at the end of the linked list
    public  void addFirst(String data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
            newNode.next = head;
            head = newNode;
    }

  public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLastNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
    }

    public void printList() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
     CustomLinkedList linkedList = new CustomLinkedList();
     linkedList.addFirst("Hello");
     linkedList.addFirst("LinkedList");
     System.out.println("After adding nodes at the beginning:");
     linkedList.printList();

     System.out.println("After adding nodes at the end:");
     linkedList.addLast("World");
     linkedList.addLast("!");
     linkedList.printList();
    }
}
