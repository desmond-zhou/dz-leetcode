class Solution {
    int[] cum;
    Random rand;
    public Solution(int[] w) {
        cum = new int[w.length];
        cum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            cum[i] = cum[i-1] + w[i];
        }
        System.out.println("cum: " + Arrays.toString(cum));
        rand = new Random();
        
    }
    
    public int pickIndex() {
        int round = rand.nextInt(cum[cum.length-1]) + 1;
        System.out.println("rand: " + round);
        return search(cum, 0, cum.length, round);
    }
    
    private int search(int[] cum, int l, int r, int target) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (cum[m] < target) l = m + 1;
            else if (cum[m] == target) r = m;
            else if (cum[m] > target && (m == 0 || cum[m-1] < target)) return r = m;
            else r = m;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */