class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int[] maxLeft = new int[arrays.size()];
        int[] minLeft = new int[arrays.size()];
        int curMin = arrays.get(0).get(0);
        int curMax = arrays.get(0).get(arrays.get(0).size()-1);
        for (int i = 1; i < arrays.size(); i++) {
            minLeft[i] = curMin;
            maxLeft[i] = curMax;
            curMin = Math.min(arrays.get(i).get(0), curMin);
            curMax = Math.max(arrays.get(i).get(arrays.get(i).size()-1), curMax);
        }
        
        int[] maxRight = new int[arrays.size()];
        int[] minRight = new int[arrays.size()];
        curMin = arrays.get(arrays.size()-1).get(0);
        curMax = arrays.get(arrays.size()-1).get(arrays.get(arrays.size()-1).size()-1);
        for (int i = arrays.size() - 2; i >= 0; i--) {
            minRight[i] = curMin;
            maxRight[i] = curMax;
            curMin = Math.min(arrays.get(i).get(0), curMin);
            curMax = Math.max(arrays.get(i).get(arrays.get(i).size()-1), curMax);
        }
        
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(minLeft));
        System.out.println(Arrays.toString(maxRight));
        System.out.println(Arrays.toString(minRight));
        
        int allMax = 0;
        for (int i = 0; i < arrays.size(); i++) {                
            int curDisMax;
            int curDisMin;
            if (i == 0) {
                curDisMax = maxRight[i];
                curDisMin = minRight[i];
            } else if (i == arrays.size() - 1) {
                curDisMax = maxLeft[i];
                curDisMin = minLeft[i];
            } else {
                curDisMax = Math.max(maxRight[i], maxLeft[i]);
                curDisMin = Math.min(minLeft[i], minRight[i]);
            }
            
            int cMin = arrays.get(i).get(0);
            int cMax = arrays.get(i).get(arrays.get(i).size()-1);
            
            curMax = Math.max(curDisMax - cMin, cMax - curDisMin);
            allMax = Math.max(curMax, allMax);
        }
        
        return allMax;
    }
}