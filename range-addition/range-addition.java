class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        Arrays.sort(updates, (a,b) -> Integer.compare(a[0], b[0]));
        final PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[length];
        
        for (int i = 0; i < updates.length; i++) {
            queue.offer(new int[]{updates[i][0], updates[i][2]});
            queue.offer(new int[]{updates[i][1] + 1, -updates[i][2]}); // inclusive means that one extra index for reversal
        }
        
        int curSum = 0;
        for (int i = 0; i < length; i++) {
            while (!queue.isEmpty() && queue.peek()[0] <= i) {
                int[] update = queue.poll();
                System.out.println("See event: " + Arrays.toString(update));
                curSum += update[1];
            }
            result[i] = curSum;
        }
        
        return result;
    }
}