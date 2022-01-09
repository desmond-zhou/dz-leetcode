class Solution {
    private static int A = (int)'a', B = (int)'b', C = (int)'c';
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pool = new PriorityQueue<>((o1,o2) -> -Integer.compare(o1[1], o2[1]));
        pool.add(new int[]{A, a});
        pool.add(new int[]{B, b});
        pool.add(new int[]{C, c});
        
        StringBuilder sb = new StringBuilder();
        int[] nextLargest = pool.poll();
        
        // 5, 3, 1
        // 
        while (true) {
            int[] largest = nextLargest; //b,3
            int nextLargestCount = (pool.isEmpty()) ? 0 : pool.peek()[1]; //b
            if (largest[1] >= nextLargestCount + 2) { 
                sb.append((char)largest[0]);  //aa
                sb.append((char)largest[0]); 
                largest[1] -= 2;        //3
            } else if (largest[1] > 0) {// aab
                sb.append((char)largest[0]);
                largest[1]--;
            } else {
                return sb.toString();
            }
            if (pool.isEmpty()) return sb.toString();
            nextLargest = pool.poll(); //b,3
            pool.add(largest); //a3,c1
        }
    }
}

