class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int soFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            soFar = Math.max(soFar + nums[i], nums[i]);
            max = Math.max(max, soFar);
        }
        max = Math.max(max, soFar);
        return max;
    }
}