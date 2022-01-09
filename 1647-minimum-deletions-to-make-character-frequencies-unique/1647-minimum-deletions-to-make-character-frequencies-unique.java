class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.putIfAbsent(c, 0);
            counts.compute(c, (k,v) -> v + 1);
        }
        ArrayList<Integer> freqs = new ArrayList<>();
        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            freqs.add(e.getValue());
        }
        freqs.sort((a,b) -> -Integer.compare(a,b));
        
        // aaabbcc -> a3,b3,c2
        // b4,c,e,a
        int removal = 0;
        int lastFreq = -1;
        for (int i = 0; i < freqs.size(); i++) {
            int curFreq = freqs.get(i); //a, b2
            if (lastFreq == -1){
                lastFreq = curFreq; // lastfreq = 3
            } else {
                if (lastFreq == 0) {
                    removal += curFreq; //remove all current
                } else if (curFreq >= lastFreq) {
                    removal += curFreq - (lastFreq - 1); //remove to be smaller than current; // 3 - (3-1) = 1
                    lastFreq--; // lower ceiling; 2//
                } else {
                    lastFreq = curFreq; //already smaller, lower the freq
                }
            }
        }
        
        return removal;
    }
}