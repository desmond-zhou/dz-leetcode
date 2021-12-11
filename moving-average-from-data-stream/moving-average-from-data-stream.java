class MovingAverage {
    final int size;
    final LinkedList<Integer> deque = new LinkedList<>();
    int total = 0;
    
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        deque.offer(val);
        total += val;
        
        if (deque.size() > size) {
            int evict = deque.poll();
            total -= evict;
        }
        
        double average = (double) total / deque.size();
        return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */