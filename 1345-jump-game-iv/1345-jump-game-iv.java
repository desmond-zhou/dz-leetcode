class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> identicals = new HashMap<>();

        int[] bestSteps = new int[arr.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
            
        for (int i = 0; i < arr.length; i++) {
            identicals.putIfAbsent(arr[i], new LinkedList<Integer>());
            if (i == 0 || i == arr.length - 1 || arr[i] != arr[i-1] || arr[i] != arr[i+1]) 
                identicals.get(arr[i]).add(i); //OPTIMIZE: preprocessing to resolve teleporter
            bestSteps[i] = i;
        }
        
        pq.offer(new int[]{0, 0});
        
        boolean[] visited = new boolean[arr.length];
        
        while (!pq.isEmpty()) {
            int[] candidate = pq.poll();
            int i = candidate[1];
            int iScore = candidate[0];
            
            if (visited[i] || iScore > bestSteps[i]) continue;
            
            //System.out.println("visit: " + i  + " : " + bestSteps[i]);
            
            int tentativeDis = bestSteps[i] + 1;
            
            conditionalUpdate(i - 1, tentativeDis, pq, visited, bestSteps);    
            conditionalUpdate(i + 1, tentativeDis, pq, visited, bestSteps);
                
            List<Integer> teleport = identicals.getOrDefault(arr[i], List.of());
            for (int teleportI : teleport) {
                if (teleportI == i) continue;
                conditionalUpdate(teleportI, tentativeDis, pq, visited, bestSteps);
            }
            
            identicals.remove(arr[i]); //OPTIMIZE: found the best path out of the teleporting group
            
            visited[i] = true;
        }
        
        return bestSteps[arr.length - 1];
    }
    
    private void conditionalUpdate(int index, int tentativeDis, PriorityQueue<int[]> pq, boolean[] visited, int[] bestSteps) {
        if (index >= 0 && index < bestSteps.length && !visited[index]) {
            if (tentativeDis < bestSteps[index]) {
                bestSteps[index] = tentativeDis;
            }
            pq.offer(new int[]{tentativeDis, index});
        }
    }
}