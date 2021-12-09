class Solution {
    static final int S = 0;
    static final int E = 1;
    
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        if (intervals.length < 2) return intervals;
        
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[S], b[S]));
        
        int curSegS = intervals[0][S];
        int curSegE = intervals[0][E];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][S] <= curSegE) 
                curSegE = Math.max(intervals[i][E], curSegE);
            else {
                result.add(new Pair(curSegS, curSegE));
                curSegS = intervals[i][S];
                curSegE = intervals[i][E];
            }
        }
        result.add(new Pair(curSegS, curSegE));
        
        int[][] rArr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            rArr[i] = new int[]{result.get(i).getKey(), result.get(i).getValue()};
        }
        
        return rArr;
    }
}