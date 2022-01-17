class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] mod = new int[nums.length];
        int curMod = 0;
        for (int i = 0 ; i < mod.length; i++) {
            curMod = (curMod + nums[i]) % k;
            mod[i] = curMod;
        }
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mod[i] == 0 && i > 0) return true;
            if (valToIndex.containsKey(mod[i]) && valToIndex.get(mod[i]) < i - 1) return true;
            valToIndex.putIfAbsent(mod[i], i);
        }
        return false;
    }
}