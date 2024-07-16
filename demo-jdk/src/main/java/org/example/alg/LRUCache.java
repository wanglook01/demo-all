package org.example.alg;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(){

        }
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    public Map<Integer,Node> map = new HashMap<>();

    public Node head = null;

    public Node tail = null;

    int size = 0;

    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-2,-2);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        //移除之前的节点
        Node n = node.next;
        Node p = node.prev;
        p.next = n;
        n.prev = p;
        //将node节点加入到队尾并返回
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(size == capacity){
            removeFirst();
        }
        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
        size++;
    }

    public void insert(Node node) {
        Node p = tail.prev;
        p.next = node;
        node.prev = p;
        node.next = tail;
        tail.prev = node;
    }

    public void removeFirst() {
        int key = head.next.key;
        map.remove(key);
        Node n = head.next.next;
        head.next = n;
        n.prev = head;
        size--;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(2,6);
        cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
        cache.put(3,3);
        cache.put(4,4);
        int i3 = cache.get(1);
        System.out.println(i3);
    }
}
