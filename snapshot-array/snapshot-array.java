class SnapshotArray {
    final ArrayList<TreeMap<Integer, Integer>> buckets;
    int curSnap = 0;
    
    public SnapshotArray(int length) {
        buckets = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            buckets.add(new TreeMap<Integer, Integer>());
        }
    }
    
    public void set(int index, int val) {
        TreeMap<Integer, Integer> bucket = buckets.get(index);
        bucket.put(curSnap, val);
    }
    
    public int snap() {
        curSnap++;
        return curSnap - 1;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> bucket = buckets.get(index);
        if (bucket.containsKey(snap_id) ) return bucket.get(snap_id);
        Map.Entry<Integer, Integer> lastValue = bucket.floorEntry(snap_id);
        if (lastValue != null) return lastValue.getValue();
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */