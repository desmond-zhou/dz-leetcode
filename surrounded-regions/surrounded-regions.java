class Solution {
    public void solve(char[][] board) {
        int ym = board.length;
        int xm = board[0].length;
        for (int y = 0; y < ym; y++) {
            for (int x = 0; x < xm; x++) {
                if (board[y][x] == 'O') {
                    capture(board, y, x);
                }
            }
        }
        
        for (int y = 0; y < ym; y++) {
            for (int x = 0; x < xm; x++) {
                if (board[y][x] == 'E') {
                    board[y][x] = 'O';
                }
            }
        }
    }
    private int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    
    private void capture (char[][] board, int y, int x) {
        LinkedList<int[]> q = new LinkedList<int[]>();
        int[] start = new int[]{y, x};
        q.offer(start);
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        boolean capture = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.println("visit: " + Arrays.toString(cur));
            visited.add(new Pair<>(cur[0], cur[1]));
            for (int[] d : dir) {
                int[] next = new int[]{cur[0] + d[0], cur[1] + d[1]};
                if (next[0] < 0 || next[1] < 0 || next[0] >= board.length || next[1] >= board[0].length) capture = false;
                else if (board[next[0]][next[1]] == 'O' && !visited.contains(new Pair<>(next[0], next[1]))) {
                    visited.add(new Pair<>(next[0], next[1]));
                    q.offer(next);
                }
            }
        }
        
        
        for (Pair<Integer, Integer> cap : visited) {
            if (capture) board[cap.getKey()][cap.getValue()] = 'X';
            else board[cap.getKey()][cap.getValue()] = 'E';
        }
    }
}