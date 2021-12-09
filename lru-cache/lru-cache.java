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
    int curSize = 0;
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<>();
        
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        //System.out.println("GET: " + key + " H: " + head + " T: " + tail + " S: " + curSize);

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            put(key, node.val);
            return node.val;
        } else
            return -1;
    }
    
    public void put(int key, int value) {
        //System.out.println("PUT: " + key + " : " + value + " H: " + head + " T: " + tail +  " S: " + curSize);
        if (map.containsKey(key)) remove(map.get(key));
        if (curSize == capacity) remove(tail);
        
        Node newNode = new Node(value, key, null, head);
        map.put(key, newNode);
        if (head != null) head.prev = newNode;
        head = newNode;
        if (tail == null) tail = newNode;
        curSize++;
    }
    
    public void remove(Node node) {
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