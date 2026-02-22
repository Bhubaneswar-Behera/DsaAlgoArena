package com.neetcode150.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LRUCacheUsingLinkedHashMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map .Entry<K,V> eldest){
        return  size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap<String,Integer> map = new LRUCacheUsingLinkedHashMap<>(3);

        map.put("A",85);
        map.put("B",86);
        map.put("C",88);
        map.put("G",76);
        map.get("A");
        map.get("G");
        map.get("B");
        System.out.println(map);
    }
}
