class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null){
            return new int[0];
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1 = 0;
        int p2 = 0;
        
        HashSet<Integer> result = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }
        
        int[] resultArr = new int[result.size()];
        int tari = 0;
        for(Integer i : result) {
            resultArr[tari] = i;
            tari++;
        }
        return resultArr;
    }
}