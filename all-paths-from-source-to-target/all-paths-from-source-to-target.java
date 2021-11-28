class Solution {
    ArrayList<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, graph, new ArrayList<Integer>());      
        return sol;
    }
    
    public void dfs(int node, int[][] graph, ArrayList<Integer> resultSoFar) {
        resultSoFar.add(node);
        if (node == graph.length - 1) {
            ArrayList<Integer> fin = new ArrayList<Integer>();
            fin.addAll(resultSoFar);
            sol.add(fin);
        } else {
            for (int next : graph[node]) {
                dfs(next, graph, resultSoFar);
            }
        }
        resultSoFar.remove(resultSoFar.size() - 1);
    }
}