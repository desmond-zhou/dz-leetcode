class TicTacToe {
    final short[][] board;
    
    public TicTacToe(int n) {
        board = new short[n][n];
    }
    
    private boolean validateMove(int[] start, int[] end, int[] direction, int player) {
        boolean win = true;
        int[] cur = start;
        while(true) {
            if (board[cur[0]][cur[1]] != player) {
                win = false;
                break;
            }
            //BUG: Check value first, then check if break or keep going.
            if (cur[0] == end[0] && cur[1] == end[1]) break;
            cur = new int[]{cur[0] + direction[0], cur[1] + direction[1]};       
        }
        return win;
    }
    
    private int validate(int row, int col, int player) {
        int last = board.length - 1;
        if (validateMove(new int[]{0,col},new int[]{last,col},new int[]{1,0}, player)) return player;
        if (validateMove(new int[]{row,0},new int[]{row,last},new int[]{0,1}, player)) return player;
        if (validateMove(new int[]{0,0},new int[]{last,last},new int[]{1,1}, player)) return player;
        if (validateMove(new int[]{0,last},new int[]{last,0},new int[]{1,-1}, player)) return player;
        else return 0;
    }
    
    public int move(int row, int col, int player) {
        //BUG: reversed column and row.
        board[row][col] = (short) player;
        return validate(row, col, player);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */