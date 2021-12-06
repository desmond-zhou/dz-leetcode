class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int ym = board.length;
        int xm = ym == 0 ? 0 : board[0].length;
        for (int y = 0; y < ym; y++) {
            for (int x = 0; x < xm; x++) {
                int[] coord = {y, x};
                char first = val(coord, board);
                if (first == word.charAt(0) || first == ' ') {
                    boolean foundY = search(board, coord, word, new int[]{0,1});
                    boolean foundX = search(board, coord, word, new int[]{0,-1});
                    boolean foundNY = search(board, coord, word, new int[]{1,0});
                    boolean foundNX = search(board, coord, word, new int[]{-1,0});
                    if (foundY || foundX || foundNY || foundNX) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean onBoard(int[] coord, char[][] board) {
        return (coord[0] < board.length && coord[0] >= 0 && coord[1] < board[0].length && coord[1] >= 0);
    }
    
    public char val(int[] coord, char[][] board) {
        return board[coord[0]][coord[1]];
    }
    
    public int[] sum(int[] a, int[] b) {
        return new int[]{a[0] + b[0], a[1] + b[1]};
    }
    
    public boolean search(char[][] board, int[] coord, String word, int[] vector) {
        boolean found = true;
        int[] prev = sum(coord, new int[]{-vector[0], -vector[1]});
        if (onBoard(prev, board) && (val(prev, board) == ' ' || Character.isLowerCase(val(prev, board)))) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            int[] curCoord = sum(coord, new int[]{i * vector[0], i * vector[1]});
            
            if (!onBoard(curCoord, board)) {
                found = false;
                break;
            } else if (val(curCoord, board) == '#') {
                found = false;
                break;
            } else if (val(curCoord, board) == word.charAt(i) || val(curCoord, board) == ' ') {
                continue;
            } else {
                found = false;
                break;
            }
        }
        
        if (found) {
            int[] next = sum(coord, new int[]{vector[0] * word.length(), vector[1] * word.length()});
            if (onBoard(next, board) && (val(next, board) == ' ' || Character.isLowerCase(val(next, board)))) {
                found = false;
            }
        }
        
        return found;
    }
}