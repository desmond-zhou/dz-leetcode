class Solution {
    static final int S = 0;
    static final int E = 1;
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> {
            if (a[E] == b[E]) return 0;
            if (a[E] < b[E]) return -1;
            return 1;
        });
        
        int arrows = 1;
        int xStart, xEnd, firstEnd = points[S][E];
        for (int[] p : points) {
            xStart = p[S];
            xEnd = p[E];
            
            // if the current balloon start after the end of another one,
            // one need one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }           
        }
        
        return arrows;
    }
}