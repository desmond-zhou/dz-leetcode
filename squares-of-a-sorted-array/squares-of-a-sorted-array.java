class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] newNum = new int[nums.length];
        int s = 0;
        int e = nums.length - 1;
        int newE = nums.length - 1;
        while(s <= e) {
            int ss = nums[s] * nums[s];
            int ee = nums[e] * nums[e];
            if (ss > ee) {
                newNum[newE] = ss;
                s++;
            } else {
                newNum[newE] = ee;
                e--;
            }
            newE--;
        }
        
        return newNum;
    }
}