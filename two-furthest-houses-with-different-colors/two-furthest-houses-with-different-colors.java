class Solution {
    public int maxDistance(int[] colors) {
        int s = 0;
        int e = colors.length - 1;
        int dis = 0;
        while(s < e) {
            if (colors[s] == colors[e]) {
                s++;
            } else {
                dis = e - s;
                break;
            }
        }
        
        s = 0;
        e = colors.length - 1;
        while(s < e) {
            if (colors[s] == colors[e]) {
                e--;
            } else {
                dis = Math.max(dis, e - s);
                break;
            }
        }
        
        return dis;
    }
}