package com.leetcode.journey.linkedlist.stacks.queues;

import java.util.HashMap;

/**
 *
 * https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LRUCache {

    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        dll.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            dll.moveToHead(node);
        } else {
            if (cache.size() == capacity) {
                Node tail = dll.removeTail();
                cache.remove(tail.key);
            }
            Node newNode = new Node(key, value);
            dll.addToHead(newNode);
            cache.put(key, newNode);
        }
    }

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList {
        private final Node head, tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeTail() {
            Node tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
    }
}
