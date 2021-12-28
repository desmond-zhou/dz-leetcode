/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int ym = dim.get(0);
        int xm = dim.get(1);
        int leftMostOne = -1;
        for (int y = 0; y < ym; y++) {
            int boundary = binarySearch(binaryMatrix, y, leftMostOne, xm);
            System.out.println("y: " + y + " boundary: " + boundary);
            leftMostOne = (boundary == -1) ? leftMostOne : boundary;
        }
        return leftMostOne;
    }
    
    //0000001
    //0011111
    //0000111
    
    private int binarySearch(BinaryMatrix binaryMatrix, int y, int leftMostOne, int xm) {
        if (leftMostOne != -1 
            && binaryMatrix.get(y, leftMostOne) == 0) return leftMostOne; // prune
        
        int l = 0;
        int r = xm - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int mVal = binaryMatrix.get(y, m);
            if (mVal == 1 && m == 0) return m;
            if (mVal == 1 && binaryMatrix.get(y, m - 1) == 0) return m;
            else if (mVal == 1) r = m;
            else l = m + 1;
        }
        
        return -1;
    }
}