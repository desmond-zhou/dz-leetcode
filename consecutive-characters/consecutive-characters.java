class Solution {
    public int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        char cur = s.charAt(0);
        int curCount = 1;
        int maxCount = 1;
        
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == cur) {
                curCount++;
            } else {
                maxCount = Math.max(maxCount, curCount);
                cur = s.charAt(i);
                curCount = 1;
            }
        }
        maxCount = Math.max(maxCount, curCount);
        
        return maxCount;
    }
}