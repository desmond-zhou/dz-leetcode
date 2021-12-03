class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    int size = 0;
    Node root;
    Node tail;
    
    public MyLinkedList() {
    }
    
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        
        Node cur = root;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        Node n = new Node(val, null, null);
        if (size == 0) {
            root = n;
            tail = n;
        } else {
            n.next = root;
            root.prev = n;
            root = n;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node n = new Node(val, null, null);
        if (size == 0) {
            root = n;
            tail = n;
        } else {
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        Node n = new Node(val, null, null);
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        } else if (index > size) {
            return;
        }
        
        Node cur = root;
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        n.prev = cur;
        n.next = cur.next;
        n.prev.next = n;
        n.next.prev = n;
        size++;
    }

    public void print() {
        Node current = root;
        while(current != null) {
            System.out.print(current.val + " - ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        } else if (size == 1) {
            root = null;
            tail = null;
            size--;
            return;
        } else if (index == 0) {
            root = root.next;
            root.prev = null;
            size--;
            return;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        } 
        
        Node cur = root;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */