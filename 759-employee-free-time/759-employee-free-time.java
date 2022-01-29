/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    int S = 0, E = 1;
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int numEmployee = 0;
        List<int[]> events = new ArrayList<>(); // event of employee id and start or end
        for (int e = 0; e < schedule.size(); e++) {
            List<Interval> intervals = schedule.get(e);
            for (Interval interval : intervals) {
                events.add(new int[]{interval.start, S});
                events.add(new int[]{interval.end, E});
            }
        }
        
        events.sort((a,b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        List<Interval> result = new ArrayList<>();
        int workingCount = 0;
        int intervalStartTime = -1;
        int curTime = 0;
        
        for (int i = 0 ; i < events.size(); i++) {
            int[] event = events.get(i);
            
            curTime = event[0];
            if (event[1] == S) {
                workingCount++;
                if (workingCount > 0) {
                    if (intervalStartTime != -1 && curTime > intervalStartTime) {
                        result.add(new Interval(intervalStartTime, curTime));
                        intervalStartTime = -1;
                    }
                }
            }
            if (event[1] == E) {
                workingCount--;
                if (workingCount == 0) intervalStartTime = curTime;
            }
        }
        
        return result;
    }
}

// A : 0-2, 3-5, 10-11 -> non overlapping is given
// B : 2-3, 7-10
// common, non-zero free time
