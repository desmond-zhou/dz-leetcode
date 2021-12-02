class Solution {
    public int removeElement(int[] nums, int val) {
        int s = 0;
        int e = 0;
        
        while (e < nums.length) {
            if (nums[s] != val) {
                s++;
                e++;
                continue;
            }
            
            while (e < nums.length) {
                if (nums[e] != val) {
                    nums[s] = nums[e];
                    s++;
                    e++;
                    continue;
                }
                e++;
            }
        }
        
        return s;
    }
}