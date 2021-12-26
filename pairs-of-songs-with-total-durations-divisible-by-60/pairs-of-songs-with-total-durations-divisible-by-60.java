class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> remain = new HashMap<>();
        for (int t : time) {
            int r = t % 60;
            remain.putIfAbsent(r, 0);
            remain.compute(r, (k, v) -> v + 1);
        }
        
        System.out.println("remain: " + remain);
        int ways = 0;
        for (int n : remain.keySet()) {
            if (n == 0 || n == 30) {
                if (remain.containsKey(n)) ways += choose(remain.get(n), 2);
            } else if (n > 30) {
                continue;
            } else {
                ways += remain.getOrDefault(n, 0) * remain.getOrDefault(60 - n, 0);
            }
        }
        
        return ways;
    }
    
    public int choose(int total, int choose){
        if(total < choose)
        return 0;
    if(choose == 0 || choose == total)
        return 1;
    return choose(total-1,choose-1)+choose(total-1,choose);
}
}