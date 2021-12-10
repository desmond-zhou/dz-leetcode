class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        return minDiff(nums, 0, nums.length - 1, 3);
    }
    
    public int minDiff(int[] nums, int l, int h, int k) {
        if (h - l <= k) return 0;
        if (k == 0) return nums[h] - nums[l];
        return Math.min(minDiff(nums, l+1, h, k-1), minDiff(nums, l, h-1, k-1));
    }
}