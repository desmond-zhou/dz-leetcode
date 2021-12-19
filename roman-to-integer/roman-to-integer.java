class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> valueMap =
            Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D',  500, 'M', 1000);
        
        int seen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int val = valueMap.get(c);
            
            if (val >= seen) {
                seen = val;
                sum += val;
            } else {
                sum -= val;
            }
        }
        
        return sum;
    }
}