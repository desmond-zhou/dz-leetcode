class Solution {
    public static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public static final int YLABEL = 0, XLABEL = 1;
    
    private boolean inBound(int y, int x, int[][] grid) {
        return y >= 0 && x >= 0 && y < grid.length && x < grid[0].length;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxSize = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1 && !visited[y][x]) {
                    maxSize = Math.max(searchSize(y, x, grid, visited), maxSize);
                } else 
                    continue;
            }
        }
        
        return maxSize;
    }
    
    private int searchSize(int y, int x, int[][] grid, boolean[][] visited) {
        if (!inBound(y, x, grid) || visited[y][x] || grid[y][x] == 0) return 0;
        visited[y][x] = true;
        
        int islandSize = 1;
        for (int[] direction : DIRECTIONS) {
            islandSize += searchSize(y + direction[YLABEL], x + direction[XLABEL], grid, visited);
        }
        return islandSize;
    }
}