class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> iStack = new Stack<>();
        int maxSize = 0;
        iStack.push(-1);
        
        for (int i = 0; i <= heights.length; i++) {
            while (iStack.peek() != -1 && 
                   (i == heights.length || heights[iStack.peek()] >= heights[i])) {
                int considerH = heights[iStack.pop()];
                int rightBound = i;
                int leftBound = iStack.peek() + 1;
                maxSize = Math.max(maxSize, considerH * (rightBound - leftBound));
            }
            iStack.push(i);
        }
        
        return maxSize;
    }
}