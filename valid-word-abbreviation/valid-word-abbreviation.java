class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wi = 0;
        int ai = 0;
        int curCount = 0;
        while (wi < word.length() && ai < abbr.length()) {
            if (Character.isDigit(abbr.charAt(ai))) {
                int curDig = Character.getNumericValue(abbr.charAt(ai));
                if (curCount == 0 && curDig == 0) return false; // leading zero
                curCount = curCount * 10 + curDig;
                ai++;
                continue;
            } else if (curCount != 0) {
                curCount--;
                wi++;
                continue;
            }
            
            System.out.println("compare: " + word.charAt(wi) + " : " + abbr.charAt(ai));
                
            if (word.charAt(wi) == abbr.charAt(ai)) {
                wi++;
                ai++;
                continue;
            } 
            return false;
        }
        
        if (wi != word.length() - curCount || ai != abbr.length()) return false;
        return true;
    }
}
