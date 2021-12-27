class TimeMap {
    HashMap<String, TreeMap<Integer, String>> data;

    public TimeMap() {
        data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        data.putIfAbsent(key, new TreeMap<>());
        data.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) return "";
        Map.Entry<Integer, String> floor = data.get(key).floorEntry(timestamp);
        if (floor == null) return "";
        return floor.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */