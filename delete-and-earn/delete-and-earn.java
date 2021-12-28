class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> valCount = new TreeMap<Integer, Integer>();
        for (int n : nums) valCount.compute(n, (k, v) -> (v == null) ? 1 : v + 1);
        
        int using = 0;
        int avoid = 0;
        int prev = -1;
        
        for (Integer value : valCount.navigableKeySet()) {
            int bestSoFar = Math.max(avoid, using);
                
            if (value - 1 != prev) {
                using = valCount.get(value) * value + bestSoFar; 
                avoid = bestSoFar;
            } else {
                using = valCount.get(value) * value + avoid;
                avoid = bestSoFar;
            }
            
            prev = value;
        }
        
        return Math.max(avoid, using);
    }
}