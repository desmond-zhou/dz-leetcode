class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                if (!compareTwo(words[i-1], words[i], orderMap)) return false;
            }
        }
        
        return true;
    }
    
    private boolean compareTwo(String words1, String words2, Map<Character, Integer> orderMap) {
        int checkI = 0;
        while (checkI < words1.length() && checkI < words2.length()) {
            char c1 = words1.charAt(checkI);
            char c2 = words2.charAt(checkI);
            if (orderMap.get(c1) == orderMap.get(c2)) checkI++;
            else if (orderMap.get(c2) > orderMap.get(c1)) return true;
            else if (orderMap.get(c2) < orderMap.get(c1)) return false;
        }
        
        if (checkI < words2.length()) {
            return true;
        } else if (checkI == words1.length() && checkI == words2.length()) {
            return true;
        }
        
        return false;
    }
}