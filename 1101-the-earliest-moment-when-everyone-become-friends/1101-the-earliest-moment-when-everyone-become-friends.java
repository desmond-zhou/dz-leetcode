class Solution {
    int groups;
    Map<Integer, Integer> membership = new HashMap<>();
    
    public int earliestAcq(int[][] logs, int n) {
        this.groups = n;
        for (int i = 0; i < n; i++) membership.put(i, i);
        Arrays.sort(logs, (a,b) -> Integer.compare(a[0], b[0]));
        for (int[] entry : logs) {
            if (union(entry[1], entry[2])) groups--;
            if (groups == 1) return entry[0];
        }
        return -1;
    }
    
    private boolean union(int a, int b) {
        if (find(a) != find(b)) {
            membership.put(find(a), find(b));
            return true;
        } 
        return false;
    }
    
    private int find(int member) {
        if (membership.get(member) == member) return member;
        int groupLead = find(membership.get(member));
        membership.put(member, groupLead);
        return groupLead;
    }
}