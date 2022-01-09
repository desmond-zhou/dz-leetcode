class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> groups = new HashMap<>();
        for (String s : strings) {
            String key = normalize(s);
            groups.putIfAbsent(key, new ArrayList<String>());
            groups.get(key).add(s);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (HashMap.Entry<String, ArrayList<String>> e : groups.entrySet()) {
            result.add(e.getValue());
        }
        
        return result;
    }
    
    private String normalize(String s) {
        char minC  = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int cycleOffset = ((c - minC) + 26 ) % 26;
            sb.append((char)(cycleOffset + 'a')) ;
        }
        System.out.println("set: " + s + "--" + sb.toString());
        return sb.toString();
    }
}