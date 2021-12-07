//Given an input string s and a pattern p, regular expression matching with '.' and '*' where:
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).

class Solution {
    
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }
    
    public boolean match(String s, int sin, String p, int pin) {
        //System.out.println("Match: " + 
        //                   (pin >= p.length() ? "nil" : p.charAt(pin)) + 
        //                   " - " + 
        //                   (sin >= s.length() ? "nil" : s.charAt(sin)));
        if (sin == s.length() && pin == p.length()) {
            return true;
        } else if (pin == p.length()) {
            return false;
        }
            
        char cur = p.charAt(pin);
        if (pin < p.length() - 1 && p.charAt(pin + 1) == '*') {
            for (int ms = sin; ms <= s.length(); ms++) {
                if (match(s, ms, p, pin + 2))
                    return true;
                if (cur != '.' && ms < s.length() && s.charAt(ms) != cur ) break;
            }
        } else if (cur == '.') {
            return match(s, sin + 1, p, pin + 1);
        } else {
            if (sin >= s.length() || pin >= p.length()) {
                return false;
            }
            
            if (s.charAt(sin) == p.charAt(pin))  {
                return match(s, sin + 1, p, pin + 1);
            } else {
                return false;
            }        
        }
        return false;
    }
}