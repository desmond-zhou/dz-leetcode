class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<List<Integer>,List<String>> groups = new HashMap<List<Integer>, List<String>>();
        for (String s : strings) {
            List<Integer> normalized = normalize(s);
            groups.putIfAbsent(normalized, new ArrayList<String>());
            groups.get(normalized).add(s);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<List<Integer>, List<String>> entry : groups.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
    
    private List<Integer> normalize(String input) {
        List<Integer> diffList = new ArrayList<>();
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char cur = input.charAt(i);
            int diff = cur - prev;
            if (diff < 0) diff += 26;
            diffList.add(diff);
            prev = cur;
        }
        System.out.println("s: " + input + " diff: " + diffList);
        return diffList;
    }
}


//diff: -1
//ba = 28, 27
//diff: -1
//az = 27, 26