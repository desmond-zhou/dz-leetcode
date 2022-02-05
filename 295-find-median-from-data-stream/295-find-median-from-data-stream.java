class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
    PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> -Integer.compare(a,b));
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (min.isEmpty() || num >= min.peek()) min.offer(num);
        else max.offer(num);
        
        if (min.size() > max.size() + 1) max.offer(min.poll());
        else if (max.size() > min.size() + 1) min.offer(max.poll());    
    }
    
    private void show() {
        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }
    public double findMedian() {
        if (min.size() + max.size() == 0) return 0.0;
        if (min.size() == max.size()) return (min.peek() + max.peek()) / 2.0;
        else if (min.size() > max.size()) return min.peek();
        else return max.peek();
    }
}