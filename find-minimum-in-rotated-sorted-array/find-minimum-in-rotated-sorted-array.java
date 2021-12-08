class Solution {
    public int findMin(int[] nums) {
        int s = 0; 
        int e = nums.length - 1;
        int mid = (s + e) / 2;
        while(true) {
            int next = (mid == nums.length - 1) ? nums[0] : nums[mid + 1];
            int prev = (mid == 0) ? nums[nums.length - 1] : nums[mid - 1];

            //System.out.println("s: " + s + " e: " + e + " mid: " + mid 
            //                   + " val " + nums[mid] + " prev " + prev + " next " + next);

            if (nums[mid] < next && nums[mid] < prev) {
                return nums[mid];
            } else if (e - s < 3) {
                return Math.min(nums[e], Math.min(nums[s], nums[mid]));
            } else if (nums[mid] > nums[s] && nums[s] > nums[e])  {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = (s + e) / 2;
        }
    }
}