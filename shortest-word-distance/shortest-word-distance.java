class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Integer i1 = null;
        Integer i2 = null;
        Integer dis = null;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) i1 = i;
            if (wordsDict[i].equals(word2)) i2 = i;
            
            if (i1 != null && i2 != null) {
                if (dis == null) dis = Math.abs(i1-i2);
                else dis = Math.min(Math.abs(i1-i2), dis);
            }
        }
        return dis;
    }
}