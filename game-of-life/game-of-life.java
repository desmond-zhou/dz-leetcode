class Solution {
    public static final int D = 0, L = 1, DL = 2, LD = 3;
    public void gameOfLife(int[][] board) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                board[y][x] = evolve(board, y, x);
            }
        }
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                board[y][x] = interpret(board, y, x);
            }
        }
    }
    
    public static final int[][] DIR = new int[][]{{0,1}, {1,0}, {-1,0}, {0, -1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
    private int evolve(int[][] board, int y, int x) {
        int live = 0;
        int dead = 0;
        for (int[] dir : DIR) {
            int[] d = new int[]{y + dir[0], x + dir[1]};
            if (d[0] < 0 || d[1] < 0 || d[0] > board.length - 1 || d[1] > board[0].length - 1) dead++;
            else if (board[d[0]][d[1]] == D || board[d[0]][d[1]] == DL) dead++;
            else live++;
        }
        
        if (board[y][x] == D && live == 3) return DL;
        else if (board[y][x] == L && live < 2) return LD;
        else if (board[y][x] == L && live > 3) return LD;
        else return board[y][x];
    }
    
    private int interpret(int[][] board, int y, int x) {
        if (board[y][x] == L || board[y][x] == DL) return L;
        else return D;
    }
}