class Solution {
    public String longestCommonPrefix(String[] strs) {
        int candidateIndex = 0;
        while (true) {
            Character candidate = null;
            for (String str : strs) {
                if (candidateIndex > str.length() - 1) {
                    return str;
                }
                
                if (candidate == null) {
                    candidate = str.charAt(candidateIndex);
                }
                
                if (str.charAt(candidateIndex) == candidate) {    
                    continue;
                } else {
                    return str.substring(0, candidateIndex);
                }
            }
            candidateIndex++;
        }
    }
}