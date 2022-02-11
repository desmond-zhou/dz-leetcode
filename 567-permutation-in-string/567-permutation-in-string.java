class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] f1 = toFreqs(s1);
        int[] f2 = new int[26];
        
        int l = 0;
        int r = 0;
        while (r < s2.length()) {
            char add = s2.charAt(r);
            f2[add - 'a']++;
            r++;
            
            if (r - l > s1.length()) {
                char remove = s2.charAt(l);
                f2[remove - 'a']--;
                l++;
            }
            
            boolean isSame = true;
            for (int i = 0; i < f2.length; i++) {
                if (!(f2[i] == f1[i])) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return true;
        }
        return false;
    }
    
    private int[] toFreqs(String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }
        return freqs;
    }
}