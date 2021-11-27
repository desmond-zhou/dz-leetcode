class State {
    int y;
    int x;
    int n;
    public State( int y, int x, int n) {
        this.y = y;
        this.x = x;
        this.n = n;
    }
    
    @Override 
    public String toString() {
        return this.y + "," + this.x + "," + this.n;
    }
    @Override
    public boolean equals(Object other){
        if (!(other instanceof State)) {
            return false;
        } else {
            return (this.y == ((State) other).y)
                && (this.x == ((State) other).x)
                && (this.n == ((State) other).n);
        }
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + y;
        result = 31 * result + x;
        result = 31 * result + n;
        return result;
    }
}
class Solution {
    public HashMap<State, Integer> cache = new HashMap<>();
    
    public int knightDialer(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[][] moves = {{1,2},{1,-2},{2,1},{2,-1},
                     {-1,2},{-1,-2},{-2,1},{-2,-1}};
        int[][] board = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1}};
        
        int count = 0;
        for (int y = 0; y < board.length; y++){
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] >= 0) {
                    count = (count + search(board, y, x, moves, n - 1))
                        % (1000000000 + 7); 
                }
            }
        }
        
        return count;
    }
    
    public int search(int[][] board, int y, int x, int[][] moves, int n) {   
        if (n == 0) {
            return 1;
        } else {
            int count = 0;    
            State state = new State(y, x, n);
            if (cache.containsKey(state)) {
                //System.out.println("get: " + state);
                return cache.get(state);
            }
            for (int[] m : moves) {
                int newY = y + m[0];
                int newX = x + m[1];
                if (newY >= 0 &&
                    newX >= 0 &&
                    newY < board.length &&
                    newX < board[0].length &&
                    board[newY][newX] >= 0) {
                    count = (count + search(board, newY, newX, moves, n - 1))
                        % (1000000000 + 7);
                }
            }
            //System.out.println("put: " + state);
            cache.put(state, count);
            return count;
        }
    }
}