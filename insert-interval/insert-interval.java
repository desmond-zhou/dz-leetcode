class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {       
        if (intervals.length == 0) return new int[][]{newInterval};
                
        boolean building = false; 
        int s = newInterval[0];
        int e = newInterval[1];
        
        final ArrayList<int[]> beforeSet = new ArrayList<>();
        final ArrayList<int[]> afterSet = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            final int[] cur = intervals[i];
            if (cur[0] > newInterval[1] && cur[1] > newInterval[1]) {
                afterSet.add(cur);
            } else if (cur[0] < newInterval[0] && cur[1] < newInterval[0]) {
                beforeSet.add(cur);
            } else {
                s = Math.min(s, cur[0]);
                e = Math.max(e, cur[1]);
            }
        }
        
        beforeSet.add(new int[]{s, e});
        beforeSet.addAll(afterSet);
        
        int[][] arr = new int[beforeSet.size()][2];
        for (int i = 0; i < beforeSet.size(); i++) {
            arr[i] = beforeSet.get(i);
        }
        
        return arr;
    } 
}