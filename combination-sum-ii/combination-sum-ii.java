class Solution {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<List<Integer>> seen = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        search(candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }
    
    public void search(int[] candidates, int target, List<Integer> soFar, int i) {
        // System.out.println(soFar);
        if (seen.contains(soFar)) return;

        if (target == 0) {
            result.add(new ArrayList<>(soFar));
            seen.add(soFar);
            return;
        }
        
        if (target < 0 || i >= candidates.length) {
            seen.add(soFar);
            return;
        } 

        
        soFar.add(candidates[i]);
        search(candidates, target - candidates[i], soFar, i + 1);
        soFar.remove(soFar.size() - 1);
        search(candidates, target, soFar, i + 1);
        seen.add(soFar);
    }
}