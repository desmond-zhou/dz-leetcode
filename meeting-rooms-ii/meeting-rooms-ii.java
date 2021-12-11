class Solution {
    // interval index
    static final int S = 0;
    static final int E = 1;
    
    // stack entry index
    static final int T = 0;
    static final int R = 1;
    
    public int minMeetingRooms(int[][] intervals) {
        final PriorityQueue<int[]> stack = new PriorityQueue<>((int[] a, int[] b) -> Integer.compare(a[T], b[T]));
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[S], b[S]));
        int cursor = 0;
        int concur = 0;
        int maxConcur = 0;
        for (int[] i : intervals) {
            cursor = Math.max(cursor, i[S]);
            stack.add(new int[]{i[S],  1});
            stack.add(new int[]{i[E], -1});
            
            while (stack.peek()[T] <= cursor) {
                int[] entry = stack.poll();
                concur += entry[R];
                maxConcur = Math.max(maxConcur, concur);
            }
        }
        
        while (!stack.isEmpty()) {
            int[] entry = stack.poll();
            concur += entry[R];
            maxConcur = Math.max(maxConcur, concur);
        }
        
        return maxConcur;
    }
} 