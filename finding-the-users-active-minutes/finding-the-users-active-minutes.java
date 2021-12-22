class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int count) {
        HashMap<Integer, TreeSet<Integer>> data = new HashMap<Integer, TreeSet<Integer>>();
        for (int[] e : logs) {
            data.putIfAbsent(e[0], new TreeSet<Integer>());
            data.get(e[0]).add(e[1]);
        }
        
        HashMap<Integer, Integer> amMap = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, TreeSet<Integer>> entry : data.entrySet()) {
            amMap.putIfAbsent(entry.getValue().size(), 0);
            amMap.compute(entry.getValue().size(), (k,v) -> v + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            if (amMap.containsKey(i)) result.add(amMap.get(i));
            else result.add(0);
        }
        
        int[] rA = new int[result.size()];
        for (int i = 0; i < result.size(); i ++) {
            rA[i] = result.get(i);
        }
        
        return rA;
        
    }
}