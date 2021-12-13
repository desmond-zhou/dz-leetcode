class Solution {
    public int arrangeCoins(int n) {
        if (n == 0) return 0; 
            
        long l = 1;
        long r = n;
        
        while (l < r) {
            long m = l + (r - l)/2;
            if (n == triangle(m) || (n > triangle(m) && n < triangle(m + 1))) return (int) m;
            if (n > triangle(m)) l = m + 1;
            if (n < triangle(m)) r = m;
        }
        
        return 1;
    }
    
    private long triangle(long m) {
        System.out.println("TRI: " + m + ":" + ((m + 1) * m / 2));
        return (m + 1) * m / 2;
    }
}