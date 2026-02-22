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

        head = new Node(0, 0);  // dummy head
        tail = new Node(0, 0); // dummy tail
        //Why dummy?
        //Ans :
        //So that :
        //We never deal with null
        //Insert/remove logic becomes simple
        //No edge-case for empty list

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);// Fetch node from map
        remove(node);// Remove the node from its current position
        insertAtHead(node);// Insert it at the head (most recently used)
        return node.value;// Return value
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);// Get the existing node
            node.value = value;// Update its value
            remove(node);// Remove the node from its current position
            insertAtHead(node);// Insert it at the head (most recently used)
        } else {
            if (map.size() == capacity) {// If the cache is full
                Node lru = tail.prev; // is the least recently used node
                map.remove(lru.key);// Remove the least recently used node from map
                remove(lru);// Remove it from the linked list
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

    // Inserts the node right after the head because Head → Most Recently Used side.
    // After insertion:
    // Head <-> NewNode <-> OldFirstNode ...
    private void insertAtHead(Node node) {
        node.next = head.next;// Connect the new node to the next node
        node.next.prev = node;// Connect the next node's previous to the new node
        head.next = node;// Connect the head to the new node
        node.prev = head;// Connect the new node's previous to the head
    }

    public static void main(String[] args) {

    }
}
