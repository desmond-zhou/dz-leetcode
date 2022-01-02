class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (!Character.isAlphabetic(lc) && !Character.isDigit(lc)) l++;
            else if (!Character.isAlphabetic(rc) && !Character.isDigit(rc)) r--;
            else if (Character.toLowerCase(lc) == Character.toLowerCase(rc)) {
                l++;
                r--;
            } else return false;
        }
        return true;
    }
}