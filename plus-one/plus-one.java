class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0; 
        for (int i = digits.length - 1; i >= 0; i--) {
            int newD = digits[i] + carry;
            if (i == digits.length - 1) {
                newD = newD + 1;
            }
            carry = 0;
            digits[i] = newD % 10;
            if (newD > 9) {
                carry = 1;
            }
        }
        if (carry > 0) {
            int[] newDig = new int[digits.length+1];
            newDig[0] = carry;
            for (int i = digits.length-1; i >= 0; i--) {
                newDig[i + 1] = digits[i];
            }
            return newDig;
        } else {
            return digits;
        }
    }
}