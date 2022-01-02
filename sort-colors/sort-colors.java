class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int n : nums) counts[n]++;
        int index = 0;
        for (int n = 0; n < counts.length; n++) {
            int newIndex = index + counts[n];
            Arrays.fill(nums, index, newIndex, n);
            index = newIndex;
        }
    }
}