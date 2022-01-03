class Solution {
    public int findJudge(int n, int[][] trustSet) {
        int[] trustCount = new int[n + 1];
        int[] trustedCount = new int[n + 1];
        for (int[] trust : trustSet) {
            trustCount[trust[0]]++;
            trustedCount[trust[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && trustedCount[i] ==  n - 1) return i;
        }
        return -1;
    }
}