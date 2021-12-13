class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        
        int s = findStart(nums, target, 0, nums.length - 1);
        int e = findEnd(nums, target, 0, nums.length - 1);
        
        return new int[]{
                (nums[s] == target ? s : -1),
                (nums[e] == target ? e : -1)};
    }
    
    public int findStart(int[] nums, int target, int l, int r) {
        if (l == r) return l; // boundary condition
        
        int m = (l + r) / 2;
        System.out.println("s" + l + "," + r + ":" + nums[(l + r)/2]);
        if (nums[m] == target && (m <= 0 || nums[m-1] < target)) return m; //BUG confused index with number
        else if (nums[m] < target) return findStart(nums, target, m + 1, r); //BUG eliminated area
        else return findStart(nums, target, l, m);
    }
    
    public int findEnd(int[] nums, int target, int l, int r) {
        if (l == r) return l;
        
        int m = (l + r) / 2;
        //System.out.println("e" + l + "," + r + ":" + nums[(l + r)/2]);
        if (nums[m] == target && (m >= nums.length - 1 || nums[m+1] > target)) return m; //BUG check all references for boundary
        else if (nums[m] <= target) return findEnd(nums, target, m + 1, r);
        else return findEnd(nums, target, l, m);
    }
}