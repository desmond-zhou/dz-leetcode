class Solution {
    public int lengthOfLastWord(String s) {
        int total = 0;
        int i = s.length() - 1;
        boolean counting = false;
        while (i >= 0) {
            if (counting == false && s.charAt(i) == ' ') {
                i--;
                continue;
            } else if (counting == true && s.charAt(i) == ' ') {
                break;
            }
            
            counting = true;
            total++;
            i--;
        }
        
        return total;
    }
}