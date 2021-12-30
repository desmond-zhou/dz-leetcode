class LFUCache {
    TreeMap<Integer, LinkedHashSet<Integer>> freqIndex = new TreeMap<>();
    HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    int curCapacity = 0;
    int capacity;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (capacity == 0 || !valueMap.containsKey(key)) return -1;
        incrementUse(key);
        return valueMap.get(key);
    }
    
    private void incrementUse(int key) {
        int originalFreq = (freqMap.containsKey(key)) ? freqMap.get(key) : 0;
        freqMap.put(key, originalFreq + 1);
        if (freqIndex.containsKey(originalFreq)) freqIndex.get(originalFreq).remove(key);
        if (freqIndex.containsKey(originalFreq) && freqIndex.get(originalFreq).size() == 0) freqIndex.remove(originalFreq);
        freqIndex.putIfAbsent(originalFreq + 1, new LinkedHashSet<Integer>());
        freqIndex.get(originalFreq + 1).add(key);
        //System.out.println("add: " + key + " freq: " + freqIndex);

    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (!valueMap.containsKey(key)) curCapacity++;


        if (curCapacity > capacity) {
            //System.out.println("before evict: " + freqIndex);
            Iterator<Integer> iter = freqIndex.firstEntry().getValue().iterator();
            int keyEvict = iter.next();
            //System.out.println("evict: " + keyEvict + " freq: " + freqMap.get(keyEvict));
            iter.remove();
            if (freqIndex.get(freqMap.get(keyEvict)).size() == 0) freqIndex.remove(freqMap.get(keyEvict));
            valueMap.remove(keyEvict);
            freqMap.remove(keyEvict);
            curCapacity--;
            //System.out.println("after evict: " + freqIndex);
        }

        incrementUse(key);
        valueMap.put(key, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// 2 cap
// p1
// p2
// g1 - 2
// p3 evict 2
// g2 = -1
// g3 - 2
// p4 evict 1