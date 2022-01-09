class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i ++) {
            count[s.charAt(i) - 'a'] ++;
        }
        
        char[] result = new char[s.length()];        
        
        for (int i = 0; i < result.length; i ++) {
            int max = 1;
            int index = -1;
            for (int j = 0; j < count.length; j ++) {
                if (count[j] >= max && (i == 0 || result[i - 1] != (char)('a' + j))) {
                    max = count[j];
                    index = j;
                    result[i] =  (char)('a' + j);
                }
            }
            
            // INSIGHT: limited character set even better than PQ
            if (index == -1) {
                return "";
            } else {
                count[index] --;
            }
        }
        
        return new String(result);
    }
}