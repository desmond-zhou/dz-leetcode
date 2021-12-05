class Solution {
    public boolean checkOnesSegment(String s) {
        boolean found = false;
        boolean done = false;
        for (char c : s.toCharArray()) {
            if (c == '1' && !found) {
                found = true;
            }
            if (c == '0' && found && !done) {
                done = true;
            }
            if (c == '1' && done) {
                return false;
            }
        }
        return true;
    }
}