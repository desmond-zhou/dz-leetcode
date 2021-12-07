class Solution {
    public boolean isStrobogrammatic(String num) {
        int s = 0;
        int e = num.length() - 1;
        while (s <= e){
            int sChar = num.charAt(s);
            int eChar = num.charAt(e);
            if (s == e && sChar != '8' && sChar != '1' && sChar != '0') return false;
            else if ((sChar == '8' && eChar == '8') 
                || (sChar == '1' && eChar == '1') 
                || (sChar == '0' && eChar == '0') 
                || (sChar == '6' && eChar == '9') 
                || (sChar == '9' && eChar == '6'))
            {
                s++;
                e--;
            } else 
                return false;
        }
        return true;
    }
}