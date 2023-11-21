class MovingAverage {
    int maxSize = 0;
    int total = 0;
    LinkedList<Integer> buffer;
    
    public MovingAverage(int size) {
        this.maxSize = size;
        buffer = new LinkedList<Integer>();
    }
    
    public double next(int val) {  
        if (buffer.size() >= maxSize) {
            Integer dropped = buffer.removeFirst();
            total = total - dropped;
        }
        
        buffer.add(val);
        total = total + val;
        
        return ((double)total) / ((double)buffer.size());
    } 
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */