class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        LinkedList<int[]> q = new LinkedList<>();
        if (grid[0][0] == 0) dp[0][0] = 1;
        else return -1;
        q.offer(coord(0,0));
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dy = -1; dy <= 1; dy++) {
                for (int dx = -1; dx <= 1; dx++) {
                    if (dy == 0 && dx == 0) continue;
                    int[] consider = coord(cur[0] + dy, cur[1] + dx);
                    if (valid(consider, grid)) {
                        if (dp[consider[0]][consider[1]] == -1 || dp[consider[0]][consider[1]] > dp[cur[0]][cur[1]] + 1) {
                            dp[consider[0]][consider[1]] = dp[cur[0]][cur[1]] + 1;
                            q.offer(consider);
                        }
                    }
                }
            }
        }
        for( int i = 0 ; i < dp.length; i ++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[grid.length - 1][grid[0].length-1];
    }
    //000
    //110
    //110
    
    private boolean valid(int[] coord, int[][] grid) {
        if (coord[0] < 0 || coord[1] < 0 || coord[0] >= grid.length || coord[1] >= grid[0].length) return false;
        if (grid[coord[0]][coord[1]] == 1) return false;
        return true;
    }
    
    private int[] coord(int y, int x) {
        return new int[]{y, x};
    }
}