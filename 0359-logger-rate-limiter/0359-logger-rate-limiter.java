class Logger {
    Map<String, Integer> messageLast = new HashMap<>();

    public Logger() {
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageLast.containsKey(message)) {
            messageLast.put(message, timestamp);
            return true;
        } else {
            int time = messageLast.get(message);
            if (timestamp < time + 10) {
                return false;
            } else {
                messageLast.put(message, timestamp);
                return true;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */