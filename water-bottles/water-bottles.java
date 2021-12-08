class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int score = 0;
        int curB = numBottles;
        int curU = 0;
        
        // drink
        while (curB > 0) {
            score = score + curB;
            curU = curU + curB;
            curB = curU / numExchange;
            curU = curU % numExchange;
        }
        
        return score;
    }
}
