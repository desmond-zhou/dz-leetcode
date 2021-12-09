class Solution {
    public static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public static final int YLABEL = 0, XLABEL = 1;
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIsland = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1' && !visited[y][x]) {
                    searchMark(y, x, grid, visited);
                    numIsland++;
                } else 
                    continue;
            }
        }
        
        return numIsland;
    }
    
    private boolean inBound(int y, int x, char[][] grid) {
        return y >= 0 && x >= 0 && y < grid.length && x < grid[0].length;
    }
    
    private void searchMark(int y, int x, char[][] grid, boolean[][] visited) {
        if (!inBound(y, x, grid) || visited[y][x] || grid[y][x] == '0') return;
        
        visited[y][x] = true;
        for (int[] direction : DIRECTIONS) {
            searchMark(y + direction[YLABEL], x + direction[XLABEL], grid, visited);
        }
    }
}