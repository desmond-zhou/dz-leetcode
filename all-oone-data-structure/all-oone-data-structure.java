class AllOne {
    TreeMap<Integer, LinkedHashSet<String>> frequency;
    HashMap<String, Integer> keys;
    
    public AllOne() {
        this.frequency = new TreeMap<>();
        this.keys = new HashMap<>();
    }
    
    public void inc(String key) {
        int previousCount;
        if (keys.containsKey(key)) {
            previousCount = keys.get(key);
            frequency.get(previousCount).remove(key);
            if (frequency.get(previousCount).isEmpty()) {
                frequency.remove(previousCount);
            }
            keys.remove(key);
        } else {
            previousCount = 0;
        }
        
        int newCount = previousCount + 1; 
        keys.put(key, newCount);
        frequency.putIfAbsent(newCount, new LinkedHashSet<String>());
        frequency.get(newCount).add(key);
        
        //System.out.println("+key: " + key + " : " + keys.get(key) + " : " + frequency.get(newCount));
    }
    
    public void dec(String key) {
        int previousCount = keys.get(key);
        frequency.get(previousCount).remove(key);
        if (frequency.get(previousCount).isEmpty()) {
            frequency.remove(previousCount);
        }
        keys.remove(key);
        
        int newCount = previousCount - 1; 
        if (previousCount > 1) {
            keys.put(key, newCount);
            frequency.putIfAbsent(newCount, new LinkedHashSet<String>());
            frequency.get(newCount).add(key);
        }
        
        //System.out.println("-key: " + key + " : " + keys.get(key) + " : " + frequency.get(newCount));
    }
    
    public String getMaxKey() {
        if (frequency.isEmpty()) return "";
        LinkedHashSet<String> container = frequency.lastEntry().getValue();
        return container.iterator().next();
    }
    
    public String getMinKey() {
        if (frequency.isEmpty()) return "";
        LinkedHashSet<String> container = frequency.firstEntry().getValue();
        return container.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */