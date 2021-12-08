class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> pq = new TreeSet<>();
        for (int num : nums) {
            if (pq.contains(num)) {
                continue;
            } else if (pq.size() < 3) { 
                pq.add(num);
            } else {
                pq.add(Math.max(num, pq.pollFirst()));
            }
        }
        
        if (pq.size() < 3) {
            return pq.pollLast();
        } else {
            return pq.pollFirst();
        }
    }
}