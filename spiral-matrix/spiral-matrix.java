class Solution {
    static final int R = 0;
    static final int D = 1;
    static final int L = 2;
    static final int U = 3;
    
    static final int Y = 0;
    static final int X = 1;
    
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int[][] directionShrink = {{0,0,1,0}, {0,0,0,1}, {-1,0,0,0}, {0,-1,0,0}};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        trim(matrix, R, new int[]{0,0}, result, new int[]{matrix[0].length-1, matrix.length-1, 0, 0});
        return result;
    }
    
    public boolean inBound(int[][] grid, int[] cell, int[] bounds) {
        boolean lb = cell[X] >= bounds[L];
        boolean ub = cell[Y] >= bounds[U];
        boolean db = cell[Y] <= bounds[D];
        boolean rb = cell[X] <= bounds[R];
        return  lb && ub && db && rb;
    }
    
    public boolean boundTight(int[] bounds) {
        return bounds[U] == bounds[D] && bounds[L] == bounds[R];
    }
    
    public void trim(int[][] grid, int dirName, int[] first, List<Integer> result, int[] bounds) {
        //System.out.println("Dir: " + dirName + " first: " + Arrays.toString(first) + " bounds: " + Arrays.toString(bounds));
        if (!inBound(grid, first, bounds)) return;
        
        int[] cell = first;
        while(true) {
            //System.out.println("visited: " + Arrays.toString(cell) + " val: " + grid[cell[Y]][cell[X]]);
            result.add(grid[cell[Y]][cell[X]]);
            
            int[] next = new int[] {cell[Y] + direction[dirName][Y], cell[X] + direction[dirName][X]};
            if (inBound(grid, next, bounds)) {
                cell = next;
            } else {
                break;
            }
        } 
        
        int nextDirectionName = (dirName + 1) % 4;
        int[] nextFirst = new int[]{cell[Y] + direction[nextDirectionName][Y], cell[X] + direction[nextDirectionName][X]};
        bounds = new int[]{bounds[R] + directionShrink[nextDirectionName][R], 
                           bounds[D] + directionShrink[nextDirectionName][D], 
                           bounds[L] + directionShrink[nextDirectionName][L], 
                           bounds[U] + directionShrink[nextDirectionName][U]};
        
        
        trim(grid, nextDirectionName, nextFirst, result, bounds);
    }
}
    