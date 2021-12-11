class Solution {
    static final int[][] DIR = {{-1,0},{0,1},{1,0},{0,-1}};
    static final int N = 0, E = 1, S = 2, W = 3;
    static final int Y = 0, X = 1;
    
    public boolean isRobotBounded(String instructions) {    
        int[] coord = new int[]{0,0};
        int dir = 0;
        
        for (char i : instructions.toCharArray()) {
            if (i == 'G') {
                coord[Y] += DIR[dir][Y];
                coord[X] += DIR[dir][X];
            } 
            else if (i == 'L') dir = (dir + 4 - 1) % 4;
            else if (i == 'R') dir = (dir + 4 + 1) % 4;
        }
        
        return (dir != 0 || (coord[X] == 0 && coord[Y] == 0)); // cannot compare object with ==
    }
}