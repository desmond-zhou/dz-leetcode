class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        color[0] = 1;
        for (int i = 0; i < graph.length; i++) {
            if (!color(i, graph, color)) return false;
        }
        return true;
    }
    
    private boolean color(int n, int[][] graph, int[] color) {
        if (color[n] == 0) color[n] = 1;
        for (int next = 0; next < graph[n].length; next++) {
            int j = graph[n][next];
            if (color[j] == 0) {
                System.out.println("search color: " +  n + ":" + color[n] + " neighbour: " + j + ":" + color[j] + ":" + Arrays.toString(color));
                color[j] = color[n] * -1;
                if (!color(j, graph, color)) return false;
            } else if (color[j] == color[n]) {
                System.out.println("break color: " +  n + ":" + color[n] + " neighbour: " + j + ":" + color[j] + ":" + Arrays.toString(color));
                return false;
            }
        }
        return true;
    }
}