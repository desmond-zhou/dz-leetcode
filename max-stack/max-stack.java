class Node {
    int val;
    Node up;
    Node down;
    public Node(int val, Node up, Node down) {
        this.val = val;
        this.up = up;
        this.down = down;
    }
}
class MaxStack {
    Node top = null;
    Node bottom = null;

    public MaxStack() {}
    
    public void push(int x) {
        final Node newItem = new Node(x, null, top);
        if (top != null) top.up = newItem;
        top = newItem;
        if (bottom == null) bottom = newItem;
    }
    
    public int pop() {
        final Node node = top;
        top = node.down;
        if (top != null) top.up = null; //BUG: forgot to update bidirection.
        if (top == null) bottom = null;
        return node.val;
    }
    
    public int top() {
        return top.val;
    }
    
    public int peekMax() {
        Node max = top;
        int curMax = top.val;
        
        Node cur = top;
        while (cur != null) {
            if (cur.val > curMax) {
                curMax = cur.val;
                max = cur;
            }
            cur = cur.down;
        }
        
        return max.val;
    }
    
    public int popMax() {
        Node max = top;
        int curMax = top.val;
        
        Node cur = top;
        while (cur != null) {
            if (cur.val > curMax) {
                curMax = cur.val;
                max = cur;
            }
            cur = cur.down;
        }
        
        if (max != top) max.up.down = max.down;
        else top = max.down;
        
        if (max != bottom) max.down.up = max.up;
        else bottom = max.up;
        
        return max.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */