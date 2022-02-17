class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recur(candidates, target, new ArrayList<Integer>(), 0, 0);    
        return results;
    }
    
    List<List<Integer>> results = new ArrayList<>();
    
    private void recur(int[] candidates, int target, List<Integer> soFar, int sum, int startIndex) {
        if (sum > target) return;
        if (sum == target) {
            results.add(new ArrayList<>(soFar));
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            int c = candidates[i];
            soFar.add(c);
            recur(candidates, target, soFar, sum + c, i);
            soFar.remove(soFar.size() - 1);
        }
    }
}