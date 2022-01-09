class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        for (int i = 0; i < n/2; i++) {
            result[index] = i + 1;
            result[index + 1] = -(i + 1);
            index += 2;
        }
        //if (index < n - 1) {
        //    result[index] = 0; //redundant in array but for clarity;
        //}
        return result;
    }
}