class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] yCheck = new boolean[board.length][9];
        boolean[][] xCheck = new boolean[board[0].length][9];
        boolean[][][] gridCheck = new boolean[board.length/3][board[0].length/3][9];
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == '.') continue;
                int digit = board[y][x] - '0' - 1; //BUG: Process character to the digit.
                //System.out.println("y: " + y + " x:" + x + " val: " + digit);
                if (yCheck[y][digit] || xCheck[x][digit] || gridCheck[y/3][x/3][digit]) return false;
                yCheck[y][digit] = true;
                xCheck[x][digit] = true;
                gridCheck[y/3][x/3][digit] = true;
            }
        }
        
        return true;
    }
}