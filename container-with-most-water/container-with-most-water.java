class Solution {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length - 1;
        
        int maxArea = 0;
        while (s < e) {
            int wall = Math.min(height[s], height[e]);
            int width = e - s;
            int area = wall * width;
            maxArea = Math.max(area, maxArea);
            
            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }
        
        return maxArea;
        
    }
}