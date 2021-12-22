class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        
        int total = 0;
        for (int n : nums) {
            total = total + n - min;
        }
        
        return total;
    }
}

// INSIGHT: increment all is the same as decrease max