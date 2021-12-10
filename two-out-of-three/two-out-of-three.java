class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        final HashMap<Integer, Integer> fre = new HashMap<>();
        
        Arrays.stream(nums1)
            .distinct()
            .forEach(item -> fre.compute(item, (k, v) -> (v==null) ? 1:v+1));
        
        Arrays.stream(nums2)
            .distinct()
            .forEach(item -> fre.compute(item, (k, v) -> (v==null) ? 1:v+1));
        
        Arrays.stream(nums3)
            .distinct()
            .forEach(item -> fre.compute(item, (k, v) -> (v==null) ? 1:v+1));
        
        
        return fre.entrySet()
            .stream()
            .filter(entry -> entry.getValue() > 1)
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
    }
}