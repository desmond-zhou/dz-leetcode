class Solution {
    public int countNegatives(int[][] grid) {
        int sum = 0;
        for (int[] row : grid) {
            int bIndex = count(row, 0, row.length);
            System.out.println(bIndex);
            if (bIndex >= row.length) continue; //BUG typo with grid and row, double check variable.
            else sum = sum + row.length - bIndex;
        }
        return sum;
    }
    
    private int count(int[] row, int l, int r) {
        int m = (l + r)/2;
        if (l == r) return l;
        if (row[m] < 0 && (m == 0 || row[m-1] >= 0)) return m;
        else if (row[m] < 0) return count(row, l, m);
        else return count(row, m + 1, r);
    }
}