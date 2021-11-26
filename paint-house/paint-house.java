class Solution {
    public int minCost(int[][] costs) {
        final int R = 0;
        final int G = 1;
        final int B = 2;
        
        int[][] dp = new int[3][costs.length];
        
        for (int i = 0; i < costs.length; i++) {
            if (i == 0) {
                dp[R][i] = costs[i][R];
                dp[G][i] = costs[i][G];
                dp[B][i] = costs[i][B];
                continue;
            }
            
            dp[R][i] = Math.min(dp[G][i-1], dp[B][i-1]) + costs[i][R];
            dp[G][i] = Math.min(dp[R][i-1], dp[B][i-1]) + costs[i][G];
            dp[B][i] = Math.min(dp[R][i-1], dp[G][i-1]) + costs[i][B];
        }
        
        int lastIndex = costs.length-1;
        return Math.min(Math.min(dp[R][lastIndex], dp[G][lastIndex]), dp[B][lastIndex]);
    }
}