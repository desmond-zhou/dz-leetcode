class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        long l = 1;
        long r = x;
        
        while (l < r) {
            long m = l + (r - l)/2;
            if (x >= m*m && x < (m+1) * (m+1)) return (int) m;
            else if (x < m*m) r = m;
            else l = m + 1;
        }
        
        return 1;
    }
}