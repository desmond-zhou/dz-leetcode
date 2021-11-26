class Solution {
    HashMap<Integer, Integer> minCostCache = new HashMap<>();
    
    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, -1);
    }
    
    public int minCostClimbingStairs(int[] cost, int target) {
        if (minCostCache.containsKey(target)){
            return minCostCache.get(target);
        }
        
        int result;
        if (target == -1) {
            int costOne = minCostClimbingStairs(cost, target + 1);
            int costTwo = minCostClimbingStairs(cost, target + 2);
            result = Math.min(costOne, costTwo);
        } else if (target == cost.length - 1){
            result = cost[target];
        } else if (target == cost.length - 2){
            result = cost[target];
        } else {
            int costOne = minCostClimbingStairs(cost, target + 1) + cost[target];
            int costTwo = minCostClimbingStairs(cost, target + 2) + cost[target];
            result = Math.min(costOne, costTwo);
        }
        
        minCostCache.put(target, result);
        return result;
    }
}