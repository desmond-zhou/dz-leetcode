class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] numSee = new int[heights.length];
        Stack<Integer> line = new Stack<>(); 
        for (int i = heights.length - 1; i >= 0; i--){
            int cur = heights[i];
            
            while (!line.isEmpty() && line.peek() <= cur) {
                numSee[i]++;
                line.pop();
            }
            
            if (!line.isEmpty()) numSee[i]++;
            
            line.push(heights[i]);
        }
        
        return numSee;
    }
}