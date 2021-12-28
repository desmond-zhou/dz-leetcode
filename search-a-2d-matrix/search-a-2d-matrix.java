class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int yl = 0;
        int yr = matrix.length;
        int ym = 0;
        boolean found = false;
        while (yl < yr) {
            ym = yl + (yr - yl) / 2;
            if (matrix[ym][0] <= target && matrix[ym][matrix[ym].length - 1] >= target) {
                found = true;
                break;
            }
            else if (matrix[ym][0] > target) yr = ym;
            else yl = ym + 1;
        }
        if (!found) return false;
        System.out.println("RowFound: " + ym);
        
        int xl = 0;
        int xr = matrix[ym].length;
        int xm = -1;
        while (xl < xr) {
            xm = xl + (xr - xl) / 2;
            if (matrix[ym][xm] == target) return true;
            else if (matrix[ym][xm] > target) xr = xm;
            else xl = xm + 1;
        }
        
        return false;
    }
}