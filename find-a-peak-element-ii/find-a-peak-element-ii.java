class Solution {
    int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public int[] findPeakGrid(int[][] mat) {
        int[] start = new int[]{(mat.length-1)/2, (mat[0].length-1)/2};
        boolean horizontal = true;
        System.out.println("test: " + Arrays.toString(start) + " : " + value(start, mat));

        while (!isPeak(start, mat)) {
            System.out.println("test: " + Arrays.toString(start) + " : " + value(start, mat));
            if (horizontal) start = climbHorizontal(start, mat);
            else if (!horizontal) start = climbVertical(start, mat);
            horizontal = !horizontal;
        }
        
        return start;
    }
    
    
    public int[] climbVertical(int[] coord, int[][] mat) {
        if (isPeak(coord, mat)) return coord;
        if (value(coord, mat) < value(apply(coord, direction[1]), mat)) {
            return searchVertical(mat, coord[1] , coord[0] + 1, mat.length - 1);
        } 
        return searchVertical(mat, coord[1], 0, coord[0]);
        
    }
    
    public int[] searchVertical(int[][] mat, int x, int yl, int yr) {
        if (yl == yr) return new int[]{yl, x};
        int mid = (yl + yr)/2;
        if (mat[mid][x] > mat[mid+1][x]) return searchVertical(mat, x, yl, mid);
        return searchVertical(mat, x, mid + 1, yr);
    }
    
    
    public int[] climbHorizontal(int[] coord, int[][] mat) {
        if (isPeak(coord, mat)) return coord;
        if (value(coord, mat) < value(apply(coord, direction[2]), mat)) {
            return searchHorizontal(mat, coord[0], coord[1] + 1, mat[coord[0]].length - 1);
        } 
        return searchHorizontal(mat, coord[0], 0, coord[1]);
    }
    
    public int[] searchHorizontal(int[][] mat, int y, int xl, int xr) {
        if (xl == xr) return new int[]{y, xl};
        int mid = (xl + xr)/2;
        if (mat[y][mid] > mat[y][mid + 1]) return searchHorizontal(mat, y, xl, mid);
        return searchHorizontal(mat, y, mid + 1, xr);
    }
    
    public boolean isPeak(int[] coord, int[][] mat) {
        for (int[] dir : direction) {
            if (value(apply(coord, dir), mat) >= value(coord, mat)) return false;
        }
        return true;
    }
    
    public int value(int[] coord, int[][] mat) {
        if (coord[0] >= 0 && coord[0] < mat.length && coord[1] >= 0 && coord[1] < mat[coord[0]].length)
            return mat[coord[0]][coord[1]];
        else
            return -1;
    }
    
    public int[] apply(int[] coord, int[] direction) {
        return new int[]{coord[0] + direction[0], coord[1] + direction[1]};
    }
}