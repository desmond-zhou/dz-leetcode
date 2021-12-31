class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeSet<int[]> startSet = new TreeSet<>((a, b) -> (a[0] == b[0]) ?  Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        TreeSet<int[]> endSet = new TreeSet<>((a, b) -> (a[0] == b[0]) ?  Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        // comparator tie break
        for (int i = 0; i < profit.length; i++) {
            startSet.add(new int[]{startTime[i], i});
            endSet.add(new int[]{endTime[i], i});
        }
        
        TreeMap<Integer, Integer> memo = new TreeMap<>();
        int bestSoFar = 0;
        while(!endSet.isEmpty()) {
            int[] event = endSet.pollFirst();
            int end = event[0];
            int index = event[1];
            int start = startTime[index];
            int profitAt = profit[index];
            Map.Entry<Integer, Integer> baseEntry = memo.floorEntry(start);
            int base = (baseEntry == null) ? 0 : baseEntry.getValue();
            int total = profitAt + base;
            bestSoFar = Math.max(total, bestSoFar);
            memo.put(end, bestSoFar);
        }
        
        System.out.println(memo);
        return memo.lastEntry().getValue();
    }
}