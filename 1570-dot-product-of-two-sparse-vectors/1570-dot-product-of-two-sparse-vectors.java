class SparseVector {
    public HashMap<Integer, Integer> countMap = new HashMap<>();
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            else countMap.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        HashMap<Integer, Integer> map1 = this.countMap;
        HashMap<Integer, Integer> map2 = vec.countMap;
        
        if (map1.size() > map2.size()) {
            map1 = vec.countMap;
            map2 = this.countMap;
        }
        
        int product = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                product += map2.get(entry.getKey()) * entry.getValue();
            }
        }
        
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);