/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int lastIndex = grid.length - 1;
        return constructRecur(grid, 0, lastIndex, 0, lastIndex);
    }
    
    // 1100
    // 0011
    // 1100
    // 0011
    
    private Node constructRecur(int[][] grid, int yS, int yE, int xS, int xE) {        
        if (yE == yS && xE == xS) {
            return new Node(grid[yE][xE] == 1, true);
        } else {
            int yM = (yS + yE) / 2;
            int xM = (xS + xE) / 2;
            Node tl = constructRecur(grid, yS, yM, xS, xM);
            Node tr = constructRecur(grid, yS, yM, xM + 1, xE);
            Node bl = constructRecur(grid, yM + 1, yE, xS, xM);
            Node br = constructRecur(grid, yM + 1, yE, xM + 1, xE);
            
            boolean allSame = List.of(tl, tr, bl, br).stream().allMatch((n) -> n.val == tl.val && n.isLeaf);
            if (allSame) {
                return new Node(tl.val, true);
            } else {
                return new Node(false, false, tl, tr, bl, br);
            }
        }
    }
}

// 0123 4567