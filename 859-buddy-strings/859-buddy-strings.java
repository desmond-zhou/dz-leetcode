class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int flipA = -1;
        int flipB = -1;
        int countWrong = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char g = goal.charAt(i);
            if (c != g) {
                countWrong++;
                if (flipA == -1) flipA = i;
                else {
                    flipB = i;
                }
            }
        }
        
        if (countWrong > 2) return false;
        
        if (flipA == -1 && flipB == -1) {
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) set.add(c);
            return (set.size() < s.length());
        }  else if (flipA != -1 && flipB == -1) {
            return false;
        }   else if (flipA != -1 && flipB != -1) {
            if (s.charAt(flipA) == goal.charAt(flipB) && s.charAt(flipB) == goal.charAt(flipA)) return true;
        } 
        
        
        return false;
    }
}