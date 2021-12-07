class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> map = new HashSet<>();
        for (String w : wordDict) {
            map.add(w);
        }
        return wordBreak(s, map);
    }
    
    public boolean wordBreak(String s, HashSet<String> map) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        if (s.isEmpty()) {
            return true;
        }
        if (map.contains(s)) {
            return true;
        }

        for (int e = 1 ; e <= s.length(); e++) {
            String sub = s.substring(0, e);
            if (map.contains(sub)) {
                String rest = s.substring(e, s.length());
                if (wordBreak(rest, map)) return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}