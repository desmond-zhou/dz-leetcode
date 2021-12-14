class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> set = new HashMap<>();
        for (String str : strs) {
            char[] key = str.toCharArray();
            Arrays.sort(key);
            String strKey = String.valueOf(key);
            set.putIfAbsent(strKey, new ArrayList<String>());
            set.get(strKey).add(str);
        }
        
        ArrayList<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : set.entrySet()) {
            result.add(e.getValue());
        }
        
        return result;
    }
}