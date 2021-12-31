
class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0 ; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) break;
                swap(nums, i, nums[i] - 1);
            }
        }
        
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        
        //BUG: one indexed array
        return nums.length + 1; //BUG: if fully formed still will be missing
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}