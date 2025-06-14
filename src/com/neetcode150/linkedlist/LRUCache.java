package com.neetcode150.linkedlist;

import java.util.HashMap;

/**
 *
 * https://leetcode.com/problems/lru-cache/description/
 * Reference : https://www.youtube.com/watch?v=VPq5dlxaeP8
 */
public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);// Remove the node from its current position
        insertAtHead(node);// Insert it at the head (most recently used)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);// Get the existing node
            node.value = value;// Update its value
            remove(node);// Remove the node from its current position
            insertAtHead(node);// Insert it at the head (most recently used)
        } else {
            if (map.size() == capacity) {// If the cache is full
                map.remove(tail.prev.key);// Remove the least recently used node
                remove(tail.prev);// Remove it from the linked list
            }
            Node newNode = new Node(key, value);// Create a new node
            map.put(key, newNode);// Add it to the map
            insertAtHead(newNode);// Insert it at the head (most recently used)
        }
    }

    // Removes the node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;// Connect the previous node to the next node
        node.next.prev = node.prev;// Connect the next node to the previous node
    }

    // Inserts the node right after the head
    private void insertAtHead(Node node) {
        node.next = head.next;// Connect the new node to the next node
        node.next.prev = node;// Connect the next node's previous to the new node
        head.next = node;// Connect the head to the new node
        node.prev = head;// Connect the new node's previous to the head
    }

    public static void main(String[] args) {

    }
}
