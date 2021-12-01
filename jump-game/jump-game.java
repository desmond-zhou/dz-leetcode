class Solution {
    short[] memo;
    
    public boolean canJump(int[] nums) {
        memo = new short[nums.length];
        return search(nums, 0);
    }
    
    public boolean search(int[] nums, int index) {
        if (memo[index] != 0) {
            return (memo[index] == -1) ? false : true;
        }
        
        if (index == nums.length - 1) {
            memo[index] = 1;
            return true;
        }
        
        int jump = nums[index];
        
        for (int i = 1; i <= jump; i++) {
            if (search(nums, index + i)) {
                memo[index] = 1;
                return true;    
            }
        }
        
        memo[index] = -1;
        return false;
    }
}