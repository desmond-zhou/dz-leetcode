class Solution {
    int n;
    int k;
    List<List<Integer>> result = new LinkedList();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return result;
    }
    
    private void backtrack(int first, LinkedList<Integer> curr) {
        // System.out.println("b: " + first + " curr: " + curr);
        if (curr.size() == k) result.add(new LinkedList(curr));
        
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }
}