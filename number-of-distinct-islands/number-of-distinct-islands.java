class Solution {
    static final int Y = 0, X = 1;
    static final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numDistinctIslands(int[][] grid) {
        final ArrayList<ArrayList<int[]>> islands = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        // build all islands
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++)  {
                if (visited[y][x]) continue;
                if (grid[y][x] == 0) continue;
                
                ArrayList<int[]> islandContent = new ArrayList<>();
                LinkedList<int[]> dfs = new LinkedList<>();
                dfs.push(new int[]{y, x});
                
                while (!dfs.isEmpty()) {
                    int[] land = dfs.pop();
                    islandContent.add(land);
                    visited[land[Y]][land[X]] = true;
                    
                    for (int[] d : dir) {
                        int[] next = apply(land, d);
                        if (checkBound(next, grid) && !isVisited(next, visited) && val(next, grid) == 1) dfs.push(next);
                    }
                }
                
                islands.add(islandContent);
            }
        }
        
        // normalize all islands and deduplicate based on hash
        HashSet<HashSet<Pair<Integer, Integer>>> normalizedIslandSet = new HashSet<>();
        for (ArrayList<int[]> island : islands) {
            HashSet<Pair<Integer, Integer>> norm = normalizeIsland(island);
            normalizedIslandSet.add(norm);
        }
        
        return normalizedIslandSet.size();
    }
    
    public HashSet<Pair<Integer, Integer>> normalizeIsland(ArrayList<int[]> island) {
        int[] base = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        for (int[] land : island) {
            base[Y] = Math.min(base[Y], land[Y]);
            base[X] = Math.min(base[X], land[X]);
        }
    
        HashSet<Pair<Integer, Integer>> normalizedIsland = new HashSet<>();
        for (int[] land : island) {
            normalizedIsland.add(new Pair<Integer, Integer>(land[Y] - base[Y], land[X] - base[X]));
        }
        
        return normalizedIsland;
    }
    
    public int[] apply(int[] coord, int[] dir) {
        return new int[]{coord[Y] + dir[Y], coord[X] + dir[X]};
    }
    
    public boolean isVisited(int[] coord, boolean[][] visited) {
        return visited[coord[Y]][coord[X]];
    }
    
    public int val(int[] coord, int[][] grid) {
        return grid[coord[Y]][coord[X]];
    }
    
    public boolean checkBound(int[] coord, int[][] grid) {
        return (coord[Y] >= 0 && coord[X] >= 0 && coord[Y] < grid.length && coord[X] < grid[0].length); //BUG: typo
    }
}