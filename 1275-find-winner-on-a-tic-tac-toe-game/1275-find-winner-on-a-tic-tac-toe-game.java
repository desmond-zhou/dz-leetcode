class Solution {
    public String tictactoe(int[][] moves) {
        Map<Integer, String> label = Map.of(1, "A", -1, "B");
        
        int[] rowCount = new int[3];
        int[] colCount = new int[3];
        int diag = 0, counterDiag = 0;

        int moveCount = 0;
        int player = 1;
        for (int[] move : moves) {
            rowCount[move[0]] += player;
            colCount[move[1]] += player;
            if (move[0] == move[1]) diag += player;
            if (move[0] == 2 - move[1]) counterDiag += player;
            
            if (Math.abs(rowCount[move[0]]) == 3 
                || Math.abs(colCount[move[1]]) == 3
                || Math.abs(diag) == 3
                || Math.abs(counterDiag) == 3) return label.get(player);
            moveCount++;
            player = -player;
        }
        
        if (moveCount == 9) return "Draw";
        
        return "Pending";
    }
}