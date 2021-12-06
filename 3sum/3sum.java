class Solution {
    Set<List<Integer>> result = new HashSet<>(); 
    
    public List<List<Integer>> threeSum(int[] nums) { 
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, nums[i], i); 
        }
        
        List<List<Integer>> list = new ArrayList<>();
        for( List<Integer> r : result){
            list.add(r);
        }
        
        return list;
    }
    
    public void twoSum(int[] nums, int target, int targetI) {        
        int s = 0;
        int e = nums.length -1;
        while (s < e) {
            //System.out.println("Consider: " + target + " S: " + nums[s] + " E: " + nums[e] + " = " + (target + nums[s] + nums[e]));
            if (s == targetI)  {
                s++;
            } else if (e == targetI) {
                e--;
            } else if (nums[s] + nums[e] + target == 0) {
                ArrayList ent = new ArrayList<>();
                ent.add(nums[s]);
                ent.add(nums[e]);
                ent.add(target);
                Collections.sort(ent);
                    
                result.add(ent);
                s++;
                e--;
            } else if (nums[s] + nums[e] + target > 0) {
                e--;
            } else {
                s++;
            }
        }
    }
}