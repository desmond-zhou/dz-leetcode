class Solution {
    public int maximum69Number (int num) {
        char[] number = Integer.toString(num).toCharArray();
        
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '6') {
                number[i] = '9';
                break;
            }
        }
        
        return Integer.parseInt(new String(number));
    }
}