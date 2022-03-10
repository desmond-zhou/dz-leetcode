class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wi = 0, ai = 0;
        int curCount = 0;
        while (wi < word.length() && ai < abbr.length()) {
            if (Character.isDigit(abbr.charAt(ai))) {
                int curDig = Character.getNumericValue(abbr.charAt(ai));
                if (curCount == 0 && curDig == 0) return false;
                curCount = curCount * 10 + curDig;
                ai++;
            } else if (curCount != 0) {
                curCount--;
                wi++;
            } else if (word.charAt(wi) == abbr.charAt(ai)) {
                wi++;
                ai++;
            } else return false;
        }
        
        if (wi != word.length() - curCount || ai != abbr.length()) return false;
        return true;
    }
}
