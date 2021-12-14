class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length < 2) return new ArrayList<List<Integer>>();
        
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minSum = -1; 
        for (int i = 1; i < arr.length; i++){
            int sum = arr[i] - arr[i-1];
            if (minSum == -1 || sum < minSum) {
                result = new ArrayList<>();
                result.add(List.of(arr[i-1], arr[i]));
                minSum = sum;            
            } else if (sum == minSum) {
                result.add(List.of(arr[i-1], arr[i]));
            } else {
                continue;
            }
        }
        
        return result;
    }
}