class Solution {
    public static final int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};
    public static final int Y = 0, X = 1;
       
    public boolean bound(final int y, final int x, final int[][] grid) {
        return y >= 0 && x >= 0 && y < grid.length && x < grid[0].length;
    }
    
    public int[][] floodFill(final int[][] image, final int sy, final int sx, final int newColor) {
        if (image[sy][sx] == newColor) return image;
        fill(image, sy, sx, image[sy][sx], newColor);
        return image;
    }    
    
    public void fill(final int[][] image, final int y, final int x, final int startColor, final int newColor) {
        if (!bound(y, x, image) || image[y][x] != startColor) return;
        
        image[y][x] = newColor;
        
        for (final int[] d : DIR) {
            fill(image, y + d[Y], x + d[X], startColor, newColor);
        }
    }
}