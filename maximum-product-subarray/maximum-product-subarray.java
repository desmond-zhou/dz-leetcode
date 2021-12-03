class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] minChain = new int[nums.length];
        int[] maxChain = new int[nums.length];
        
        boolean allZero;
        if (nums[0] == 0) {
            minChain[0] = 1;
            maxChain[0] = 1;
            allZero = true;
        } else {
            minChain[0] = nums[0];
            maxChain[0] = nums[0];
            allZero = false;
        }
        
        int maxCombo = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxChain[i] = 1;
                minChain[i] = 1;
            }
            allZero = false;
            maxChain[i] = Math.max(nums[i], Math.max(minChain[i-1] * nums[i], maxChain[i-1] * nums[i]));
            minChain[i] = Math.min(Math.min(minChain[i-1] * nums[i], maxChain[i-1] * nums[i]), nums[i]);
            int currentMax = Math.max(minChain[i], maxChain[i]);
            maxCombo = Math.max(currentMax, maxCombo);
        }
        if (allZero) return 0;
        return maxCombo;
    }
}