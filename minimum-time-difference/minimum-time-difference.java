class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minDiff = Integer.MAX_VALUE;
        Integer lastMinute = null;
        for (int i = 0; i < timePoints.size(); i++) {
            int minutes = parse(timePoints.get(i)); 
            if (lastMinute != null) {
                minDiff = Math.min(minDiff, minutes - lastMinute);
            }
            lastMinute = minutes;
        }
        int last = parse(timePoints.get(timePoints.size()-1));
        int first = parse(timePoints.get(0));
        int lastDiff = first + (24*60) - last;
        minDiff = Math.min(minDiff, lastDiff);
        return minDiff;
    }
    
    public int parse(String s) {
        String h = s.split(":")[0];
        String m = s.split(":")[1];
        return Integer.valueOf(h) * 60 + Integer.valueOf(m);
    }
}