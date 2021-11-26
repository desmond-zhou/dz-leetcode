class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if(i == 0 && j == 0) {
                    grid[i][j] = 1;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j];
                } else if(obstacleGrid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }   
                
                 if (obstacleGrid[i][j] == 1) grid[i][j] = 0;
            }
        }
        
        return grid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}