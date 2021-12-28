class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> nums = new TreeSet<>();
        HashMap<Integer, Integer> ranks = new HashMap<Integer, Integer>();
        for (int v : arr) nums.add(v);
        int cur = 1;
        for (int v : nums) {
            ranks.put(v, cur);
            cur++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranks.get(arr[i]);
        }
        return arr;
    }
}