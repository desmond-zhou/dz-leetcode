class Solution {
    public int jump(int[] nums) {
        int min[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                min[i] = 0;
            } else {
                int minPath = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (j + nums[j] >= i) {
                        minPath = Math.min(min[j] + 1, minPath);
                    }
                }
                min[i] = minPath;
            }
        }
        
        return min[min.length - 1];
    }
}