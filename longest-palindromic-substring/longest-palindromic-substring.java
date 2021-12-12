class Solution {
    public String longestPalindrome(String s) {
        int[] longest = new int[]{0,0,0};
        for (int i = 0; i < s.length(); i++) {
            int[] r = check(s, i, i);
            if (r[0] > longest[0]) {
                longest = r;
            }
            r = check(s, i, i + 1);
            if (r[0] > longest[0]) {
                longest = r;
            }
        }
        return s.substring(longest[1], longest[2] + 1);
    }
    
    private int[] check(String string, int s, int e) {
        int extend = 0;
        
        boolean found = false;
        int ds = s - extend;
        int de = e + extend;
        while (ds >= 0 && de < string.length()) {
            if (string.charAt(ds) == string.charAt(de)) extend++;
            else break;
            
            found = true;;
            ds = s - extend;
            de = e + extend;
        }
        if (!found) return new int[]{0, s, e};
            
        extend--;
        ds = s - extend;
        de = e + extend;
        
        //System.out.println("check: " + s + " : " + e + " -> " + string.substring(ds, de + 1) + " L " + (de-ds));
        
        return new int[]{de - ds, ds, de};
    }
}
