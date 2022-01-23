class Solution {
    static int F = 0, S = 1;
    static int START = 0, END = 1;
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> events = new ArrayList<>();
        for (int[] seg : firstList) {
            events.add(new int[]{seg[0], F, START});
            events.add(new int[]{seg[1], F, END});
        }
        for (int[] seg : secondList) {
            events.add(new int[]{seg[0], S, START});
            events.add(new int[]{seg[1], S, END});
        }
        events.sort((a,b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]); //sequence end after start to capture single digit range
            return Integer.compare(a[1],b[1]);
        });
        
        ArrayList<int[]> result = new ArrayList<>();
        
        boolean curF = false;
        boolean curS = false;
        int curCursor = 0;
        for (int[] event : events) {
            //System.out.println("event: " + event[0] + "-" + event[1] + "-" + event[2]);
            boolean previousState = curF && curS;
            int newCursor = event[0];
            if (event[1] == F && event[2] == START) curF = true;
            else if (event[1] == F && event[2] == END) curF = false;
            else if (event[1] == S && event[2] == START) curS = true;
            else if (event[1] == S && event[2] == END) curS = false;
            boolean newState = curF && curS;
            
            if (newState != previousState) { 
                if (newState) {
                    curCursor = newCursor;
                } else {
                    result.add(new int[]{curCursor, newCursor});
                }
            }
        }
        
        int[][] resultA = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultA[i] = result.get(i);
        }
        return resultA;
    }
}