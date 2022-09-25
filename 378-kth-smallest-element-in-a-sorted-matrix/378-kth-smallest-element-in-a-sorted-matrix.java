class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
	    //top left is the smallest value, bottom right is the largest value in this matrix
        int smallest = matrix[0][0];
        int largest = matrix[matrix.length-1][matrix[0].length-1];        
        while (smallest < largest) {
            int medVal = smallest + (largest - smallest) / 2;
            if (getNumberOfElementsSmallerThenMedVal(matrix, medVal) >= k) {  //not return even count == k, since medVal might not exist in this matrix.
                largest = medVal;
            } else {  //count < k
                smallest = medVal + 1;
            }
        }
        return smallest;
    }
    
    private int getNumberOfElementsSmallerThenMedVal(int[][] matrix, int target) {
        int count = 0;
        int i = 0;
        int j = matrix.length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= target) {
                count = count + j + 1;  //all the elements on the left hand side in this row are <= target
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}