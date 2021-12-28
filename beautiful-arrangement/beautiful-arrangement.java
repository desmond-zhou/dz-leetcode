class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        calculate(n, 1, visited);
        return count;
    }
    
    private void calculate(int n, int index, boolean[] visited) {
        if (index > n) count++;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (index % i == 0 || i % index == 0)) {
                visited[i] = true;
                calculate(n, index + 1, visited);
                visited[i] = false;
            }
        }
        
    }
}