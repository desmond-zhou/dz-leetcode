class Solution {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = x * -1;
        }
        
        int cur = Math.abs(x);
        while (cur % 10 == 0) {
            cur = cur / 10;
        }
        
        int y = 0;
        while (cur >= 10) {
            int digit = cur % 10;
            if (y > Integer.MAX_VALUE / 10) return 0;
            y = y * 10;
            y = y + digit;
            cur = cur / 10;
        }
        int digit = cur % 10;
        if (y > Integer.MAX_VALUE / 10) return 0;
        y = y * 10;
        y = y + digit;
        
        if (negative) {
            y = y * -1;
        }
        return y;
    }
}