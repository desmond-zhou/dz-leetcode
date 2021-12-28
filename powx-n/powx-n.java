class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0;
        if (n == 0) return 1;
        
        boolean negX = false, negN = false; 
        if (x < 0) {
            negX = true;
            x = Math.abs(x);
        }
        if (n < 0) {
            negN = true;
            n = Math.abs(n);
        }
        
        double result = powSearch(x, n);
        
        if (negX && n % 2 == 1) {
            result = -result;
        }
        if (negN) {
            result = 1.0/result;
        }
        return result;
    }
    
    private double powSearch(double x, int n) {        
        int curP = 1;
        double curV = x;
        while (curP <= n/2) {
            curV = curV * curV;
            curP = curP * 2;
        }
        
        if (curP == n) return curV;
        return curV * powSearch(x, n - curP);
    }
    
}