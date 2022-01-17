class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        HashMap<Integer, Integer> runningProcess = new HashMap<>();
        Stack<int[]> orderProcess = new Stack<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        
        int[][] logSequence = new int[logs.size()][3];
        int addIndex = 0;
        for (int i = 0; i < logs.size(); i++) {
            String logEntry = logs.get(i);
            String[] tokens = logEntry.split(":");
            int id = Integer.valueOf(tokens[0]);
            int markType = (tokens[1].equals("start")) ? 0 : 1;
            int timestamp = Integer.valueOf(tokens[2]);
            logSequence[i] = new int[]{id, markType, timestamp};
        }
        
        Arrays.sort(logSequence, (a,b) -> {
            if (a[2] == b[2]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[2], b[2]);
        });
        
        int cursor = 0;
        Integer currentProcess = null;
        for (int i = 0; i < logSequence.length; i++) {
            int[] logEntry = logSequence[i];
            int id = logEntry[0];
            int type = logEntry[1];
            int timestamp = logEntry[2];
            final int cursorF = cursor;
            
            if (type == 0) {
                runningProcess.putIfAbsent(id, 0);
                runningProcess.compute(id, (k,v) -> v+1);
                orderProcess.push(new int[]{id, runningProcess.get(id)});
                
                if (currentProcess != null) {
                    result.putIfAbsent(currentProcess, 0);
                    result.compute(currentProcess, (k,v) -> v + (timestamp - cursorF));
                }
                
                currentProcess = orderProcess.peek()[0];
                cursor = timestamp;
            } else if (type == 1) {
                runningProcess.compute(id, (k,v) -> (v-1 == 0) ? null : v-1);
                while (!orderProcess.isEmpty() && (!runningProcess.containsKey(orderProcess.peek()[0]) 
                                                   || runningProcess.get(orderProcess.peek()[0]) < orderProcess.peek()[1]))
                    orderProcess.pop();
                
                if (currentProcess != null) {
                    result.putIfAbsent(currentProcess, 0);
                    result.compute(currentProcess, (k,v) -> v + (timestamp - cursorF + 1));
                }
                
                currentProcess = (!orderProcess.isEmpty()) ? orderProcess.peek()[0] : null;
                cursor = timestamp + 1;
            }
        }
        
        int[] timing = new int[n];
        for (int i = 0; i < n ; i++) {
            timing[i] = result.get(i);
        }
        
        return timing;
    }
}