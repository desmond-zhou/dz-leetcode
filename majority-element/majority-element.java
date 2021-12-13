class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int candidateCount = 1;
        int otherCount = 0;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) candidateCount++;
            else otherCount++;
            if (candidateCount < otherCount) {
                candidate = nums[i];
                candidateCount = 0;
                otherCount = 0;
            }
        }
        
        return candidate;
    }
}