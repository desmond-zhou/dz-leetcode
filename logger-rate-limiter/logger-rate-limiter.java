class Logger {
    HashMap<String, Integer> entry;
    public Logger() {
        this.entry = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastTime = entry.get(message);
        if (lastTime != null) {
            if (timestamp >= lastTime + 10) {
                entry.put(message, Math.max(timestamp, lastTime));
                return true;
            }
            else {
                return false;
            }
        } else {
            entry.put(message, timestamp);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */