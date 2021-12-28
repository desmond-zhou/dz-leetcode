class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        if (memo.containsKey(s)) return memo.get(s);
        
        if (s.length() == 0) return 1;
        
        int num = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String token = tmp.append(s.charAt(i)).toString();
            if (Integer.valueOf(token) == 0) {
                return 0;
            } else if (Integer.valueOf(token) <= 26) {
                num += numDecodings(s.substring(i + 1));
            } else {
                break;
            }
        }
        memo.put(s, num);
        return num;
    }
}