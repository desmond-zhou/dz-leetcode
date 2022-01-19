class Solution {
    public String removeOuterParentheses(String s) {
        int[] right = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right[i] = (i == 0) ? 1 : right[i - 1] + 1;
            } else {
                right[i] = (i == 0) ? 1 : right[i - 1] - 1;
            }
        }
        
        int[] left = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                left[i] = (i == s.length() - 1) ? 1 : left[i + 1] + 1;
            } else {
                left[i] = (i == s.length() - 1) ? 1 : left[i + 1] - 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (right[i] != 0 && left[i] != 0) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}