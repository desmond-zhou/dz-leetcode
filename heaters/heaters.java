class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int he = 0;
        long minDis = 0;
        for (int house : houses) {
            while (he + 1 < heaters.length && dis(heaters[he + 1], house) <= dis(heaters[he], house)) {
                he++;
            }
            long curMin = dis(heaters[he], house);
            minDis = Math.max(minDis, curMin);
        }
        return (int) minDis;
    }

    public long dis(int a, int b) {
        return Math.abs(a - b);
    }
}