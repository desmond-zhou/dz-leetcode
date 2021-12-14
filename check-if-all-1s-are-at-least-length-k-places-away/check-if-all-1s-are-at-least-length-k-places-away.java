class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prevIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (prevIndex != -1 && nums[i] == 1 && i - prevIndex < k + 1) return false;
            if (nums[i] == 1) prevIndex = i;
        }
        return true;
    }
}


//01234
//3