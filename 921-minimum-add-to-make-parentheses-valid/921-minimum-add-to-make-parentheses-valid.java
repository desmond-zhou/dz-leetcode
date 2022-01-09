class Solution {
    public int minAddToMakeValid(String s) {
        if (s.isEmpty()) return 0;
        
        int bal = 0;
        int minBal = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') bal++;  
            else if (c == ')') bal--;
            minBal = Math.min(bal, minBal);
        }
        
        int adj = Math.abs(minBal);
        int adjustedLast = bal + adj;
        return adj + adjustedLast;
    }
}