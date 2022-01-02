
class MyHashMap {
    Object[] data = new Object[5987];
    
    
    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        LinkedList<int[]> bucket = (LinkedList<int[]>)data[hash(key)];
        if (bucket == null) { 
            bucket = new LinkedList<int[]>();
            data[hash(key)] = bucket;
        }
        for(int[] pair : bucket) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        bucket.add(new int[]{key, value});
    }
    
    private int hash(int key) {
        return key % 5987;
    }
    
    public int get(int key) {
        LinkedList<int[]> bucket = (LinkedList<int[]>)data[hash(key)];
        if (bucket == null) return -1;
        for(int[] pair : bucket) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        LinkedList<int[]> bucket = (LinkedList<int[]>)data[hash(key)];
        if (bucket == null) return;
        Iterator<int[]> iter = bucket.iterator();
        while (iter.hasNext()) {
            int[] pair = iter.next();
            if (pair[0] == key) {
                iter.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */