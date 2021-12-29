class Node {
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int val, int key, Node prev, Node next) {
        this.val = val;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
    public String toString() {
        return "["+ ((prev == null) ? "X" : prev.val) + "<" + key + "," + val + ">" + ((next == null) ? "X" : next.val) + "]";
    }
}

class LRUCache {
    final int capacity;
    final HashMap<Integer, Node> map = new HashMap<>();
    int curSize = 0;
    Node head = null, tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        //System.out.println("GET: " + key + " H: " + head + " T: " + tail + " S: " + curSize);
        Node node = map.get(key);
        if (node == null) return -1;
        this.put(key, node.val);
        return node.val;
    }
    
    public void put(int key, int value) {
        //System.out.println("PUT: " + key + " : " + value + " H: " + head + " T: " + tail +  " S: " + curSize);
        this.remove(map.get(key));
        if (curSize == capacity) remove(tail);
        this.append(key, value);
    }
    
    public void append(int key, int value) {
        final Node node = new Node(value, key, null, head);
        map.put(key, node);
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;
        curSize++;
    }
    
    public void remove(Node node) {
        if (node == null) return;
        if (node == head) head = node.next;
        if (node == tail) tail = node.prev;
        if (node.next != null) node.next.prev = node.prev;
        if (node.prev != null) node.prev.next = node.next;
        map.remove(node.key);
        curSize--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */