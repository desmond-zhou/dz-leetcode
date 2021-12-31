class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0 ; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) break;
                swap(nums, i, nums[i] - 1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) result.add(i + 1);
        }
        
        return result;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}