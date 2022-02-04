class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> countIndex = new HashMap<>();
        int maxLen = 0;
        int balance = 0;
        countIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) balance--;
            else balance++;
            //System.out.println("i" + i + "b" + balance);
            int firstSeen = countIndex.getOrDefault(balance, i);
            maxLen = Math.max(maxLen, i - firstSeen);
            countIndex.putIfAbsent(balance, i);
        }  
        return maxLen;
    }
}
