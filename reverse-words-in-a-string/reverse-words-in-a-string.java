class Solution {
    public String reverseWords(String s) {
        
        char[] sArr = s.toCharArray();
        int i = 0;
        int segS = 0;
        while (true) {
            if ( i == sArr.length - 1) {
                reverse(sArr, segS, i);
                break;
            }
            
            if (sArr[i] == ' ') {
                reverse(sArr, segS, i - 1);
                segS = i + 1;
            } 
            
            if (segS == sArr.length) break;
            i++;
        }
        
        //BUG swaps go all the way will double up.
        
        for (i = 0; i < sArr.length/2; i++) {
            char tmp = sArr[i];
            sArr[i] = sArr[sArr.length - 1 - i];
            sArr[sArr.length - 1 - i] = tmp;
        }
        
        return new String(sArr).trim().replaceAll(" +", " ");
    }
    
    private void reverse(char[] sArr, int segS, int segE) {
        while (segS < segE) {
            char tmp = sArr[segS];
            sArr[segS] = sArr[segE];
            sArr[segE] = tmp;
            segS++;
            segE--;
        }
    }
}