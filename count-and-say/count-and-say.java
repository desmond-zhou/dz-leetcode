class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        else return say(countAndSay(n-1));
    }

    public String say(String n) {
        ArrayList<int[]> countMap = new ArrayList<>();
        Character prevC = null;
        int count = 0;
        for (char c : n.toCharArray()) {
            if (prevC == null || prevC == c) {
                count++;
                prevC = c;
            } else {
                countMap.add(new int[]{prevC, count});
                prevC = c;
                count = 1;
            }
        }
        countMap.add(new int[]{prevC, count});
        
        StringBuilder sb = new StringBuilder();
        for (int[] section : countMap) {
            char d = (char) section[0];
            int c = section[1];
            
            sb.append(c);
            sb.append(d);
        }
        
        return sb.toString();
    }
}