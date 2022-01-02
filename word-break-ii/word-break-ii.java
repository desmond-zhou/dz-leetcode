class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordDict);
        search(s, 0, dict, new ArrayList<>(), result);
        return result;
    }
    
    private void search(String s, int index, HashSet<String> wordDict, ArrayList<String> soFar, ArrayList<String> result) {
        if (index >= s.length()) {
            result.add(String.join(" ", soFar));
        }
        
        StringBuilder prefix = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            prefix.append(s.charAt(i));
            String prefixString = prefix.toString();
            if (wordDict.contains(prefixString)) {
                soFar.add(prefixString);
                search(s, i + 1, wordDict, soFar, result);
                soFar.remove(soFar.size() - 1);
            }
        }
        
    }
}