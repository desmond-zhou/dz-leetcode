class Solution {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adj = new HashMap<>();
    
    private void search(List<String> merged, String email) {
        visited.add(email);
        merged.add(email);
        
        if (!adj.containsKey(email)) return;
        
        for (String connected : adj.get(email)) {
            if (!visited.contains(connected)) search(merged, connected);
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int numAccounts = accounts.size();
        
        for (List<String> account : accounts) {
            int numAccount = account.size();
            
            String first = account.get(1);
            for (int j = 2; j < numAccount; j++) {
                String comp = account.get(j);
                if (!adj.containsKey(first)) adj.put(first, new ArrayList<String>());
                adj.get(first).add(comp);
                
                if (!adj.containsKey(comp)) adj.put(comp, new ArrayList<String>());
                adj.get(comp).add(first);
            }
        }
        
        List<List<String>> allMerged = new ArrayList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String first = account.get(1);
            
            if (!visited.contains(first)) {
                List<String> merged = new ArrayList<>();
                merged.add(name);
                search(merged, first);
                Collections.sort(merged.subList(1, merged.size()));
                allMerged.add(merged);
            }
        }
        
        return allMerged;
    }
}