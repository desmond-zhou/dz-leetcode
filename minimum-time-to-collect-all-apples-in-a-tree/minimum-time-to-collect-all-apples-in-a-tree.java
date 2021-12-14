class Solution {
    boolean[] visited;
    boolean[] hasAppleRec;
    Map<Integer, HashSet<Integer>> edgeM = new HashMap<>();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        visited = new boolean[n];
        hasAppleRec = new boolean[n];
        
        for (int i = 0 ; i < edges.length; i ++) {
            int[] e = edges[i];
            edgeM.putIfAbsent(e[0], new HashSet<Integer>());
            edgeM.get(e[0]).add(e[1]);
            edgeM.putIfAbsent(e[1], new HashSet<Integer>());
            edgeM.get(e[1]).add(e[0]); 
        }
        
        for (int i = 0; i < hasApple.size(); i++) {
            hasAppleRec[i] = hasApple.get(i);
        }
        
        return search(0);
    }
    
    private int search(int node) {
        visited[node] = true;
        int pathLength = 0;
        
        for (int next : edgeM.get(node)) {
            if (visited[next]) continue;
            int subCount = search(next);
            if (hasAppleRec[next]) {
                //System.out.println("Node: " + next + " added: " + subCount);
                hasAppleRec[node] = true;
                pathLength += subCount + 2;
            }
        }
        
        return pathLength;
    }
}