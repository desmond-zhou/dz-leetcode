class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] minTime = new int[grid.length][grid[0].length];
        for(int y = 0; y < minTime.length; y++) {
            Arrays.fill(minTime[y], 0, minTime[0].length, -1);
        }
        
        LinkedList<int[]> searchQueue = new LinkedList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                int value = grid[y][x];
                if (value == 2) {
                    minTime[y][x] = 0;
                    searchQueue.offer(new int[]{y, x});
                }
            }
        }
        
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        
        while (!searchQueue.isEmpty()) {
            int[] cur = searchQueue.poll();
            int time = minTime[cur[0]][cur[1]];
            for (int[] d : directions) {
                int[] next = apply(cur, d);
                if (canInfect(next, grid, minTime, time + 1)) {
                    minTime[next[0]][next[1]] = time + 1;
                    searchQueue.offer(next);
                }
            }
        }
        
        int maxMinTime = -1;
        int appleCount = 0;
        for (int y = 0; y < minTime.length; y++){
            System.out.println("memo: " + y + " : " + Arrays.toString(minTime[y]));
            for (int x = 0; x < minTime[0].length; x++){
                if (grid[y][x] != 0) appleCount++;
                if (minTime[y][x] == -1 && grid[y][x] != 0) return -1;
                else maxMinTime = Math.max(maxMinTime, minTime[y][x]);
            }
        }
        
        return (appleCount == 0) ? 0 : maxMinTime;
    }
    
    private int[] apply(int[] cell, int[] direction) {
        return new int[]{cell[0] + direction[0], cell[1] + direction[1]};
    }
     
    private boolean canInfect(int[] cell, int[][] grid, int[][] minTime, int time) {
        return (cell[0] >= 0 
                && cell[1] >= 0 
                && cell[0] < grid.length 
                && cell[1] < grid[0].length)
            && grid[cell[0]][cell[1]] == 1 
            && (minTime[cell[0]][cell[1]] == -1 || minTime[cell[0]][cell[1]] > time);
    }
}