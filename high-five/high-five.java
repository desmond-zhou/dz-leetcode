class Solution {
    static final int N = 0, S = 1;
    
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> -Integer.compare(a[S], b[S]));
        
        TreeMap<Integer, int[]> map = new TreeMap<>();
        
        for (int[] data : items) {
            map.putIfAbsent(data[N], new int[]{0, 0}); //BUG: initialize need to be fixed
            
            if (map.get(data[N])[0] < 5) {
                map.compute(data[N], (k, v) -> {
                    v[0]++;
                    v[1] += data[S];
                    return v;
                });
            }
        }
        
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int avg = entry.getValue()[1] / entry.getValue()[0];
            result[index] = new int[]{entry.getKey(), avg};
            index++;
        }
        
        return result;
    }
}