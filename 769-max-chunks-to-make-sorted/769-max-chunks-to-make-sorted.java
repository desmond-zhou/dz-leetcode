class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }
        
        int[] min = new int[arr.length];
        min[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            min[i] = Math.min(min[i+1], arr[i]);
        }
        
        int splitCount = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (max[i] <= min[i + 1]) splitCount++; 
        }
        
        return splitCount;
    }
}