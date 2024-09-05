package code.cache;

import java.util.*;

class Node
{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }

}
class LRUCache {

    int capacity;
    Map<Integer,Node> cache = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node data;
        if(!cache.containsKey(key))
            return -1;

        data = cache.get(key);
        deleteNode(data);
        addNode(data);
        return data.value;

    }

    public void deleteNode(Node p)
    {
        Node prev = p.prev;
        Node next = p.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addNode(Node p)
    {
        Node next = head.next;
        p.prev = head;
        p.next = next;
        next.prev = p;
        head.next = p;

    }


    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            Node data = cache.get(key);
            deleteNode(data);
            data.value = value;
            addNode(data);
        }
        else{
            if(cache.size() == capacity)
            {
                Node leastUsed = tail.prev;
                cache.remove(leastUsed.key);
                deleteNode(leastUsed);
                Node newEntry = new Node(key,value);
                addNode(newEntry);
                cache.put(key,newEntry);

            }
            else {
                Node newEntry = new Node(key,value);
                addNode(newEntry);
                cache.put(key,newEntry);
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
