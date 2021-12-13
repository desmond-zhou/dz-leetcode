class Solution {
    public int[] findBuildings(int[] heights) {
        int[] max = new int[heights.length];
        max[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            max[i] = Math.max(max[i+1], heights[i]); 
        }
        
        ArrayList<Integer> building = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (i == heights.length - 1) building.add(i);
            else if (heights[i] > max[i + 1]) building.add(i);
        }
        
        int[] r = new int[building.size()];
        for (int i = building.size() - 1; i >= 0; i--) {
            r[building.size() - 1 - i] = building.get(i);
        }
        
        return r;
    }
}