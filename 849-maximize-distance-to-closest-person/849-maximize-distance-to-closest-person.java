class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] leftMax = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            if (i == 0) leftMax[i] = (seats[i] == 0) ? Integer.MAX_VALUE : 0;
            else if (seats[i] == 1) leftMax[i] = 0;
            else if (leftMax[i-1] == Integer.MAX_VALUE) leftMax[i] = Integer.MAX_VALUE;
            else leftMax[i] = leftMax[i-1] + 1;
        }
        
        int[] rightMax = new int[seats.length];
        for (int i = seats.length - 1; i >= 0; i--) {
            if (i == seats.length - 1) rightMax[i] = (seats[i] == 0) ? Integer.MAX_VALUE : 0;
            else if (seats[i] == 1) rightMax[i] = 0;
            else if (rightMax[i+1] == Integer.MAX_VALUE) rightMax[i] = Integer.MAX_VALUE;
            else rightMax[i] = rightMax[i+1] + 1;
        }
        
        int bestDis = -1;
        int bestIndex = -1;
        for (int i = 0; i < seats.length; i++) {
            int dis = Math.min(leftMax[i], rightMax[i]);
            if (dis > bestDis) {
                bestDis = dis;
                bestIndex = i;
            }
        }
        
        return bestDis; //check for the return to align.
    }
}

// 0123456
//  *  *
// X012012 leftMax
// 10210XX rightMax