class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int cur = n;
        while (cur != 1) {
            if (seen.contains(cur)) return false;
            else seen.add(cur);
            
            int num = cur;
            int acum = 0;
            while (num != 0) {
                int digit = num % 10;
                num = num / 10;
                acum = acum + digit * digit;
            }
            cur = acum;
        }
        return true;
    }
}