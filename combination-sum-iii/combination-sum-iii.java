class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        search(k, n, new ArrayList<Integer>(), 1, result);
        return result;
    }
    
    private void search(int k , int n, ArrayList<Integer> list, int num, List<List<Integer>> result) {
        if (k == 0 && n == 0) result.add(new ArrayList<>(list));
        if (n < 0 || k < 1 || num > 9) return;
        
        list.add(num);
        search(k-1, n-num, list, num+1, result);
        list.remove(list.size() - 1);
        search(k, n, list, num+1, result);
    }
}