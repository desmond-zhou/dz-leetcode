class Solution {
    public static final int TRIM = 0;
    public static final int DIGIT = 2;
    public static final int END = 3;
    
    public int myAtoi(String s) {
        StringBuilder buff = new StringBuilder();
        int stage = TRIM;
        boolean positive = true;
        for (int i = 0; i < s.length(); i++) {
            if (stage == TRIM && s.charAt(i) == ' ') {
                continue;
            } else if (stage == TRIM && s.charAt(i) == '+') {
                stage = DIGIT;
                continue;
            } else if (stage == TRIM && s.charAt(i) == '-') {
                stage = DIGIT;
                positive = false;
                continue;
            } else if (stage == TRIM) {
                stage = DIGIT;
            }
            
            if (stage == DIGIT && Character.isDigit(s.charAt(i))) {
                buff.append(s.charAt(i));
                continue;
            } else {
                stage = END;
            }
            
            if (stage == END) {
                continue;
            }
        }
        
        String number = buff.toString();
        
        if (number.equals("0")) {
            return 0;
        } else if (number.equals("2147483648")) {
            if (positive) return Integer.MAX_VALUE;
        }
        
        boolean overFlow = false;
        int target = 0;
        for(int i = 0; i < number.length(); i++) {
            if (target > Integer.MAX_VALUE - Integer.parseInt(String.valueOf(number.charAt(i)))) overFlow = true;
            int newTarget = target + Integer.parseInt(String.valueOf(number.charAt(i)));
            if (i == number.length() - 1)
                target = newTarget;
            else {
                if (newTarget > Integer.MAX_VALUE / 10) overFlow = true;
                target = newTarget * 10;
            }
        }
        
        if (overFlow) {
            if (positive) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        } else {
            if (positive) return target;
            else return -target;
        }
    }
}