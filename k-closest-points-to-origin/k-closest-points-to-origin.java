class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return select(points, k);
    }
    
    private int[][] select(int[][] points, int k) {
        int l = 0; int r = points.length - 1;
        int p = points.length;
        while (p != k) {
            p = partition(points, l, r);
            if (p < k) {
                l = p;
            } else {
                r = p - 1;
            }
        }
        return Arrays.copyOf(points, k);
    }
    
    private int partition(int[][] points, int l, int r) {
        int[] p = choose(points, l, r);
        int pd = distance(p);
        while (l < r) {
            if (distance(points[l]) >= pd) {
                int[] tp = points[l];
                points[l] = points[r];
                points[r] = tp;
                r--;
            } else {
                l++;
            }
        }
        
        if (distance(points[l]) < pd) l++;
        return l;
    }
    
    private int[] choose(int[][] points, int l, int r) {
        return points[l + (r-l)/2];
    }
    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
    
}