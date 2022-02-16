class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] indexOfSeen = new int[26];
        Arrays.fill(indexOfSeen, -1);
        
        int count = 0;
        
        int l = 0;
        int r = 0;
        
        while (r < s.length()) {
            char addition = s.charAt(r);
            r++;
            
            if (indexOfSeen[addition - 'a'] != -1) {
                while (l <= indexOfSeen[addition - 'a']) {
                    indexOfSeen[s.charAt(l) - 'a'] = -1;
                    l++;
                }
            }
            
            indexOfSeen[addition - 'a'] = r - 1;
             
            if (r - l > k) {
                indexOfSeen[s.charAt(l) - 'a'] = -1;
                l++;
            }
            
            if (r - l == k) {
                count++;
            }
        }
        
        return count;
    }
}