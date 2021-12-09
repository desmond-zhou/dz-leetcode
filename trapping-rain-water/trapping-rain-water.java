class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        
        maxLeft[0] = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        
        //[0,1,0,2,1,0,1,3,2,1,2,1]
        // 0,0,1,1,2,2,2,3,3,3,3,3
        // 3,3,3,3,3,3,3,2,2,2,1,0
        // 0,0
             
        maxRight[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            total = total + Math.max(Math.min(maxLeft[i], maxRight[i]) - height[i], 0);
        }
        
        return total;
    }
}