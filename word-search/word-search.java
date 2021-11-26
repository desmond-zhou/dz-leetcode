class Solution {
    int[][] steps = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j= 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (search(board, word, i, j, visited, 0)) return true;
                }
            }
        }
        return false;
    }
    
    boolean search(char[][] board, String word, int i, int j, boolean[][] visited, int wordChar) {
        if (board[i][j] != word.charAt(wordChar)){
            return false;
        }
        
        if (wordChar == word.length() - 1) {
            return true;
        } 
    
        visited[i][j] = true;
        for (int s = 0; s < steps.length; s++) {
            int newI = i + steps[s][0];
            int newJ = j + steps[s][1];
                
            if (newI >= 0 && newJ >= 0 && newI < board.length && newJ < board[0].length && !visited[newI][newJ]) {
                if (search(board, word, newI, newJ, visited, wordChar + 1)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}