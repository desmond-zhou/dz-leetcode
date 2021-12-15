class Solution {
    LinkedList<Integer> stack = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] tempVisited = new boolean[numCourses];
        Map<Integer, Set<Integer>> pre = new HashMap<>();
        for (int[] entry : prerequisites){
            pre.putIfAbsent(entry[1], new HashSet<Integer>());
            pre.get(entry[1]).add(entry[0]);
        }
        for (int i = 0; i < numCourses; i ++) {
            tempVisited = new boolean[numCourses];
            boolean isValid = search(i, pre, visited, result, tempVisited); 
            if (!isValid) return new int[0];
        }
        int[] r = new int[numCourses];
        for (int i = 0 ; i < r.length; i++) {
            r[i] = result.get(r.length - 1 - i);
        }
        return r;
    }
    private boolean search(int n, Map<Integer, Set<Integer>> pre, boolean[] visited, ArrayList<Integer> result, boolean[] tempVisited) {
        if (visited[n]) return true;
        if (tempVisited[n]) return false;
        
        tempVisited[n] = true;
        if (pre.containsKey(n)) {
            for (Integer next : pre.get(n)) {
                boolean isValid = search(next, pre, visited, result, tempVisited);
                if (!isValid) return false;
            }
        }
        visited[n] = true;
        result.add(n); //TIP: Topological sorting have to be adding at the end to get the true parent first.
        return true;
    }
}