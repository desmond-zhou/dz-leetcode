class Vector2D {
    int x = 0;
    int y = 0;
    int[][] vec;
    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        if (!hasNext()) return -1;
        else {
            System.out.println("found " + y + ", " + x + ":" + vec[y][x]);
            int val = vec[y][x];
            x++;
            return val;
        }
    }
    
    private void advance() {
        while (y < vec.length) {
            System.out.println("scan: " + y + " , " + x);
            if (y >= vec.length) {
                // no way to deal with it
                break;
            }
            if (x >= vec[y].length) {
                // keep scanning
                y++;
                x=0;
            } else {
                // found a stable location
                break;
            }
        }
    }
        
    public boolean hasNext() {
        advance();
        return y < vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */