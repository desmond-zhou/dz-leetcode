class Solution {
    public int maximumSwap(int num) {
        final String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }
        
        int[] max = new int[s.length()];
        for (int i = digits.length - 1; i >= 0; i--) {
            max[i] = (i == digits.length - 1) ? digits[i] : Math.max(digits[i], max[i+1]);
        }
        
        int swapToVal = -1;
        int swapFromVal = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < max[i]) {
                swapToVal = max[i];
                swapFromVal = digits[i];
                digits[i] = max[i];
                break;
            }
        }
        
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == swapToVal) {
                digits[i] = swapFromVal;
                break;
            }
        }
        
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            result = (result * 10) + digits[i];
        }
        
        return result;
    }
}