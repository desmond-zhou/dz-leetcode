// 0|1|2|3|4
//
class Solution {
    public List<Integer> findAnagrams(String string, String p) {
        HashMap<Character, Integer> pattern = new HashMap<>();
        for (char c : p.toCharArray()) {
            pattern.compute(Character.toLowerCase(c), (k, v) -> (v == null) ? 1 : v + 1);
        }
        
        List<Integer> results = new ArrayList<>();
        HashMap<Character, Integer> match = new HashMap<>();
        int s = 0, e = 0;
        while(e < string.length()) {
            match.compute(string.charAt(e), (k,v) -> (v == null) ? 1 : v + 1);
            e++;
            
            if (e - s > p.length()) {
                match.compute(string.charAt(s), (k,v) -> (v == 1) ? null : v - 1);
                s++;
            }
            
            if (match.equals(pattern)) results.add(s);
        }
        
        return results;
    }
}