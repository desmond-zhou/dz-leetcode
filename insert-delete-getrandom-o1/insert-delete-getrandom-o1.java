class RandomizedSet {
    HashMap<Integer, Integer> m = new HashMap<>();
    ArrayList<Integer> a = new ArrayList<>();
    public RandomizedSet() {}
    
    public boolean insert(int val) {
        if (m.containsKey(val)) return false;
        
        a.add(val);
        int lastIndex = a.size() - 1;
        m.put(val, lastIndex);
        
        return true;
    }
    
    public boolean remove(int val) {
        if (!m.containsKey(val)) return false;
        int index = m.get(val);
        
        // get swap candidate
        int lastIndex = a.size() - 1;
        int lastVal = a.get(lastIndex);
        
        // swap
        a.set(index, lastVal);
        m.put(lastVal, index);
        
        // remove last
        m.remove(val);
        a.remove(lastIndex);
        
        return true;
    }
    
    Random rand = new Random();
    
    public int getRandom() {
        return a.get(rand.nextInt(a.size()));
    }
}

// hash table 


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */