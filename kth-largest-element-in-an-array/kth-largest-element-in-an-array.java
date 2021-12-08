class Solution {
    public int findKthLargest(int[] nums, int k) {
        final TreeMap<Integer, Integer> pq = new TreeMap<>();
        int totalCount = 0;
        for (int num : nums) {
            if (pq.containsKey(num)) pq.compute(num, (key, val) -> val + 1);
            else pq.put(num, 1);
            totalCount++;
            
            if (totalCount > k) {
                final Map.Entry<Integer, Integer> lowest = pq.pollFirstEntry();
                if (lowest.getValue() > 1) {
                    pq.put(lowest.getKey(), lowest.getValue() - 1);
                }
                totalCount--;
            }
        }
        
        return pq.firstEntry().getKey();
    }
}