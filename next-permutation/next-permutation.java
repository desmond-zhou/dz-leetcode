class Solution {
    public void nextPermutation(int[] nums) {
        int firstReversal = -10;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                firstReversal = i-1;
                break;
            }
        
        }
        if (firstReversal == -10) {
            Arrays.sort(nums);
            return;
        }
        
        for (int i = nums.length - 1; i > firstReversal; i--) {
            if (nums[i] > nums[firstReversal]) {
                int tmp = nums[firstReversal];
                nums[firstReversal] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        
        Arrays.sort(nums, firstReversal + 1, nums.length);
    }
}


//9365421
//9465321
//9412356