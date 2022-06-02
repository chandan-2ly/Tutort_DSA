package LinkedList;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRU_Implementation {
    public static void main(String[] args){
        int[][] nums = {{1,1},{2,2},{3,3},{4,4}};
        int capacity = 3;
        LRUCache obj = new LRUCache(capacity);
        for (int[] num : nums) {
            obj.put(num[0], num[1]);
        }
        for (int[] num : nums){
            System.out.println(obj.get(num[0]));
        }
    }
}
class LRUNode {
    LRUNode next, prev;
    int key, value;
    LRUNode(int _key, int _val){
        key = _key;
        value = _val;
    }
}
class LRUCache {
    private LRUNode head;
    private LRUNode tail;
    private HashMap<Integer, LRUNode> map;
    private int cacheSize;

    public LRUCache(int capacity) {
        head = new LRUNode(0,0);
        tail = new LRUNode(0,0);
        head.next = tail;
        tail.prev = head;
        cacheSize = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LRUNode node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if (map.size() == cacheSize){
            remove(tail.prev);
        }
        insert(new LRUNode(key, value));
    }
    private void remove(LRUNode node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(LRUNode node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

