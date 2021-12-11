class HitCounter {
    static final int T = 0;
    static final int C = 1;
    
    final LinkedList<int[]> runner;
    int totalHits = 0;

    public HitCounter() {
        this.runner = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        int[] mostRecent = runner.peekFirst();
        if (mostRecent != null && mostRecent[T] == timestamp) {
            mostRecent[C]++;
        } else {
            runner.offer(new int[]{timestamp, 1});
        }
        totalHits++;
    }
    
    private void clean(int timestamp) {
        while (runner.peek() != null && runner.peek()[T] <= timestamp - 300) {
            totalHits = totalHits - runner.peek()[C];
            runner.poll();
        }
    }
    
    public int getHits(int timestamp) {
        clean(timestamp);
        return totalHits;        
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */