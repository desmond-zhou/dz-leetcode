class Solution {
    HashMap<Integer, Integer> dSet = new HashMap<>();
    HashMap<Integer, Integer> size = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        for (int num : nums) {
            add(num);
            union(num, num + 1);
            union(num, num - 1);
        }
        
        System.out.println(dSet);
        System.out.println(size);
        
        int longest = 0;
        for (Integer k : size.keySet()) {
            longest = Math.max(longest, size.get(k));
        }
        
        return longest;
    }
    
    private void add(int a) {
        if (dSet.containsKey(a)) return;
        dSet.put(a, a);
        size.put(a, 1);
    }
    
    private void union(int a, int b) {
        if (!(dSet.containsKey(a) && dSet.containsKey(b))) return;
        int setA = find(a);
        int setB = find(b);
        if (setA != setB) {
            dSet.put(setA, setB);
            size.put(setB, size.get(setA) + size.get(setB));
            size.remove(setA);
        }
    }
    
    private int find(int a) {
        int cur = a;
        int set = cur;
        if (dSet.get(cur) != cur) {
            set = find(dSet.get(cur));
            dSet.put(cur, set);
        }
        return set;
    } 
}