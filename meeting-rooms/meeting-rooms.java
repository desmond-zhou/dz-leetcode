class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) return true;
        Arrays.sort(intervals, (int[] o1, int[] o2) -> Integer.compare(o1[0], o2[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) return false;
            end = Math.max(end, intervals[i][1]);
        }
        return true;
    }
}