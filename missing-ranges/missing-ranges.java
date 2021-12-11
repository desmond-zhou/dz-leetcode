class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        
        List<String> result = new ArrayList();
        
        int expected = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > expected) {
                result.add(makeRange(expected, nums[i] - 1));
            } 
            expected = nums[i] + 1;
        }
        
        if (upper > expected - 1) 
            result.add(makeRange(expected, upper));
        
        return result;
    }
    
    public String makeRange(int lower, int upper) {
        if (lower == upper) return "" + lower;
        return lower + "->" + upper;
    }
}