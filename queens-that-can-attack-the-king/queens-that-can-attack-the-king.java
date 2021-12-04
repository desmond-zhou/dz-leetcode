class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        HashSet<Pair<Integer, Integer>> queenSet = new HashSet<>();
        for (int[] queen : queens) {
            queenSet.add(new Pair(queen[0], queen[1]));
        }

        int[][] scans = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int kingy = king[0];
        int kingx = king[1];
        
        List<List<Integer>> results = new ArrayList<>();
        for (int[] scan : scans) {
            int cury = kingy + scan[0];
            int curx = kingx + scan[1];
            while(curx >= 0 && cury >= 0 && curx < 8 && cury < 8) {
                Pair<Integer, Integer> testCell = new Pair<>(cury, curx);
                if (queenSet.contains(testCell)) {
                    queenSet.remove(testCell);
                    List<Integer> list = new ArrayList<>();
                    list.add(cury);
                    list.add(curx);
                    results.add(list);
                    break;
                }
                cury = cury + scan[0];
                curx = curx + scan[1];
            }
        }
        
        return results;
    }
}