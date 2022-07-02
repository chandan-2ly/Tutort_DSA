package PriorityQueue_Heap;

import java.util.HashMap;

public class LRUCacheImplementation {
    public static void main(String[] args){
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));


    }
}
class LRUCache{
    private LRUNode head, tail;
    int cacheSize;
    HashMap<Integer, LRUNode> map;
    LRUCache(int _capacity){
        cacheSize = _capacity;
        head = new LRUNode(0,0);
        tail = new LRUNode(0,0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    public int get(int key){
        if(map.containsKey(key)){
            LRUNode node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    public void put(int key, int val){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == cacheSize){
            remove(tail.prev);
        }
        insert(new LRUNode(key, val));
    }

    private void insert(LRUNode node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(LRUNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
class LRUNode {
    LRUNode prev, next;
    int key, val;
    LRUNode(int _key, int _val){
        key = _key;
        val = _val;
    }
}
