class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        return compare(s,t) && compare(t,s);
    }
    private boolean compare(String s, String t) {
        HashMap<Character, Character> m = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++ ) {
            if (m.getOrDefault(s.charAt(i), t.charAt(i)) != t.charAt(i)) return false;
            else {
                m.putIfAbsent(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}