class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                if (j > nums.length - 1) {
                    continue;
                } else {
                    while(j < nums.length && nums[j] == 0) {j++;}
                    if (j > nums.length - 1) continue;
                    nums[i] = nums[j];
                    nums[j] = 0;
                    j++;
                }
            } else {
                j++;
            }
        }
    }
}