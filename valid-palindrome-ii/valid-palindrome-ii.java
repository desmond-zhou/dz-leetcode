class Solution {
       public boolean validPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i < j ; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return _validPalindrome(s.substring(0, i) + s.substring(i + 1))
                        || _validPalindrome(s.substring(0, j) + s.substring(j + 1));
            }
        }
        return true;
    }

    private boolean _validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j ; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
