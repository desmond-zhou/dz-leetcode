class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int ym = matrix.length;
        int xm = ym == 0 ? 0 : matrix[0].length;
        
        for (int y = ym - 1; y > 0; y--) {
            if (invalidDiag(new int[]{y, 0}, matrix)) return false;
        }
        
        for (int x = 0; x < xm; x++) {
            if (invalidDiag(new int[]{0, x}, matrix)) return false;
        }
        
        return true;
    }
    
    private boolean invalidDiag(int[] start, int[][] matrix) {
        System.out.println("c: " + start[0] + ", " + start[1]);
        int y = start[0];
        int x = start[1];
        int cur = matrix[y][x];
        while (y < matrix.length && x < matrix[0].length) {
            if (matrix[y][x] != cur) return true;
            x++;
            y++;
        }
        return false;
    }
    
    
}


// 2,0 - 1,0 - 0,0 - 0,1 - 0,2 - 0,3
