class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int numRemove) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int element : arr) {
            list.add(element);
            freq.compute(element, (k, v) -> (v == null) ? 1 : v + 1);
        }
        
        Collections.sort(list, (o1, o2) -> 
                         (freq.get(o1) == freq.get(o2)) ? 
                         Integer.compare(o1, o2) :
                         Integer.compare(freq.get(o1), freq.get(o2)));
        
        for (int i = 0; i < numRemove; i ++) {
            int remove = list.get(i);
            freq.compute(remove, (k, v) -> (v == 1) ? null : v - 1);
        }
        
        return freq.size();
    }
}