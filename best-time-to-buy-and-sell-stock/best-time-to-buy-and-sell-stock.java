class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        min[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min[i] = Math.min(min[i-1], prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - min[i], maxProfit);
        }
        
        return maxProfit;
    }
}