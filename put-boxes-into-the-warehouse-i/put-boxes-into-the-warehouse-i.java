class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int[] capacity = new int[warehouse.length];
        capacity[0] = warehouse[0];
        for (int i = 1; i < capacity.length; i++) {
            capacity[i] = Math.min(capacity[i-1], warehouse[i]);
        }
        
        Arrays.sort(boxes);
        
        int target = warehouse.length - 1;
        int boxIn = 0;
        for (int box : boxes) {
            while (target >= 0 && box > capacity[target]) {
                target--;
            }
            if (target < 0){
                return boxIn;
            }
            if (box <= capacity[target]) {
                target--;
                boxIn++;
            }
        }
        
        return boxIn;
    }
}