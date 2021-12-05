class Solution {
    public int addRungs(int[] rungs, int dist) {
        int prev = 0;
        int ans = 0;
        for (int rung: rungs) {
            ans += (rung - prev - 1) / dist;
            prev = rung;
        }
        return ans;
    }
}