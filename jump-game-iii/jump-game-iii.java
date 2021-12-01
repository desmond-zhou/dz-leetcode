class Solution {
    
    public boolean canReach(int[] arr, int start) {
        boolean[] reach = new boolean[arr.length];
        search(arr, start, reach);
        return findAnyZero(reach, arr);
    }


    public static boolean findAnyZero(boolean[] reach, int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && reach[i] == true) return true;
        }
      return false;
    }
    
    public void search(int[] arr, int start, boolean[] reach) {
        reach[start] = true;
        int prev = start + arr[start];
        int next = start - arr[start];
        if (prev >= 0 && prev < arr.length && !reach[prev])
            search(arr, prev, reach);
        if (next >= 0 && next < arr.length && !reach[next])
            search(arr, next, reach);
    }
}