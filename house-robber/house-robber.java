class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] loot = new int[nums.length];
        loot[0] = nums[0];
        if (nums.length >= 2) {
            loot[1] = Math.max(nums[1], nums[0]);
        }
        for (int i = 2; i < nums.length; i++) {
            loot[i] = Math.max(loot[i-1], loot[i-2] + nums[i]);
        }
        
        return loot[nums.length - 1];
    }
}