class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }
        final HashMap<Character, String> mappings = new HashMap<>();
        mappings.put('2', "abc");
        mappings.put('3', "def");
        mappings.put('4', "ghi");
        mappings.put('5', "jkl");
        mappings.put('6', "mno");
        mappings.put('7', "pqrs");
        mappings.put('8', "tuv");
        mappings.put('9', "wxyz");
        
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        search(results, digits, 0, mappings, sb);
        return results;
    }
    
    public void search(List<String> results, String digits, int index, HashMap<Character, String> mappings, StringBuilder sb) {
        if (index == digits.length()) {
            results.add(sb.toString());
            return;
        }
        
        Character chara = digits.charAt(index);
        for (Character candidate : mappings.get(chara).toCharArray()) {
            sb.append(candidate);
            search(results, digits, index+1, mappings, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}