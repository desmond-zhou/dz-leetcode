class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        final PriorityQueue<int[]> stack = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]); // go down first.
            return Integer.compare(a[0], b[0]);
        });
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));
        int curPass = 0;
        int curLoc = 0;
        for (final int[] t : trips) {
            curLoc = t[1];
            stack.offer(new int[]{t[1], t[0]});
            stack.offer(new int[]{t[2], -t[0]});
            
            while (!stack.isEmpty() && stack.peek()[1] >= curLoc) {
                int[] change = stack.poll();
                curPass += change[1];
                //System.out.println("PASS: " + curLoc + ":" + curPass);
                if (curPass > capacity) return false;
            }
        }
        while (!stack.isEmpty()) {
            int[] change = stack.poll();
            curPass += change[1];
            //System.out.println("PASS: " + curLoc + ":" + curPass);
            if (curPass > capacity) return false;
        }
        
        return true;
    }
}