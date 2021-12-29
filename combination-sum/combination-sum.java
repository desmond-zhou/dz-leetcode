class Solution { 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {        
        List<List<Integer>> result = new ArrayList<>();
        search(candidates, target, new ArrayList<Integer>(), 0, result);
        return result;
    }
    
    private void search(int[] candidates, int target, ArrayList<Integer> soFar, int pickIndex, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(soFar));
        }
        for (int i = pickIndex; i < candidates.length; i++) {
            soFar.add(candidates[i]);
            search(candidates, target - candidates[i], soFar, i, result);
            soFar.remove(soFar.size() - 1);
        }
    }
}