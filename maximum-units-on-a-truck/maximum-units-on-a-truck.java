class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));
        
        int curBox = 0;
        int curUnit = 0;
        int consider = 0;
        while (consider < boxTypes.length && curBox < truckSize) {
            int numAvai = boxTypes[consider][0];
            int unitEach = boxTypes[consider][1];
            
            //System.out.println("consider: " + numAvai + " each " + unitEach);
            if (truckSize - curBox >= numAvai) {
                curUnit += unitEach * numAvai;
                curBox += numAvai;
                consider++;
                continue;
            } else {
                int needed = truckSize - curBox;
                curUnit += unitEach * needed;
                break;
            }
        }
        
        return curUnit;
    }
}