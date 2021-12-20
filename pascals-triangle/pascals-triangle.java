class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int n = 1; n <= numRows; n++) {
            List<Integer> newRow = new ArrayList<>();
            if (n == 1) {
                newRow = List.of(1);
            } else {
                List<Integer> lastRow = results.get(results.size() - 1);
                newRow.add(lastRow.get(0));
                for (int i = 1; i < lastRow.size(); i++) {
                    newRow.add(lastRow.get(i) + lastRow.get(i-1));
                }
                newRow.add(lastRow.get(0));
            }
            
            results.add(newRow);
        }
        
        return results;
    }
}