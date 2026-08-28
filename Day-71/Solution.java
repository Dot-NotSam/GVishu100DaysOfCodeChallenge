class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) { return -1; }
        Node n = map.get(key);
        
        n.prev.next = n.next;
        n.next.prev = n.prev;

        n.prev = tail.prev;
        n.next = tail;

        tail.prev.next = n;
        tail.prev = n;

        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            
            n.next.prev = n.prev;
            n.prev.next = n.next;

            n.prev = tail.prev;
            n.next = tail;

            tail.prev.next = n;
            tail.prev = n;

            return;
        }

        if(map.size() == cap) {
            Node lru = head.next;

            head.next = lru.next;
            lru.next.prev = head;

            map.remove(lru.key);
        }

        Node curr = new Node(key, value);
        map.put(key, curr);

        tail.prev.next = curr;
        curr.next = tail;
        curr.prev = tail.prev;
        tail.prev = curr;
    }   
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
