class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (y == 0 && x == 0) memo[y][x] = grid[y][x];
                else if (y == 0) memo[y][x] = memo[y][x-1] + grid[y][x];
                else if (x == 0) memo[y][x] = memo[y-1][x] + grid[y][x];
                else memo[y][x] = Math.min(memo[y-1][x], memo[y][x-1]) + grid[y][x];
            }
        }
        return memo[grid.length - 1][grid[0].length - 1];
    }
}



